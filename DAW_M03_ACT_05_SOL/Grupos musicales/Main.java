import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception{
		ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "grupos.db4o");
		int opcion;
		do{
			opcion = menu();
			switch(opcion){
				case 1:
					crearGrupo(bd);
					break;
				case 2:
					verGrupos(bd);
					break;
				case 3:
					verGruposEstilo(bd);
					break;
				case 4:
					verGruposRock3(bd);
					break;
				case 0:
					bd.close();
					System.out.println("Adios");
					break;
				default:
					System.out.println("Opcion incorrecta");
			}
		}
		while(opcion!=0);
	}
	
	private static void verGruposRock3(ObjectContainer bd) {
		Query query = bd.query();
		query.constrain(Grupo.class);
		Constraint constr = query.descend("estilo").constrain("Rock");
		query.descend("numIntegrantes").constrain(3).greater().and(constr);
		ObjectSet res = query.execute();
		System.out.println("Recuperados " + res.size() + " grupos");
		while(res.hasNext()){
			System.out.println(res.next());
		}
	}

	private static void verGruposEstilo(ObjectContainer bd) throws Exception {
		System.out.println("Indica el estilo que quieres buscar: ");
		String estilo = br.readLine();
		Query query = bd.query();
		query.constrain(Grupo.class);
		query.descend("estilo").constrain(estilo);
		query.descend("nombre").orderAscending();
		ObjectSet res = query.execute();
		System.out.println("Recuperados " + res.size() + " grupos");
		while(res.hasNext()){
			System.out.println(res.next());
		}
	}

	private static void verGrupos(ObjectContainer bd) {
		Grupo g = new Grupo(null, null, 0);
		ObjectSet res = bd.queryByExample(g);
		
		/*Query query = bd.query();
		query.constrain(Grupo.class);
		ObjectSet res = query.execute();*/
		
		System.out.println("Recuperados " + res.size() + " grupos");
		while(res.hasNext()){
			System.out.println(res.next());
		}
	}

	private static void crearGrupo(ObjectContainer bd) throws Exception{
		System.out.println("Introduce nombre grupo:");
		String nombre = br.readLine();
		System.out.println("Introduce estilo:");
		String estilo = br.readLine();
		System.out.println("Introduce numero de integrantes:");
		int integrantes = Integer.parseInt(br.readLine());
		Grupo g = new Grupo(nombre, estilo, integrantes);
		bd.store(g);
	}

	private static int menu() throws Exception{
		System.out.println("[1] - Crear grupo");
		System.out.println("[2] - Ver grupos");
		System.out.println("[3] - Ver por estilo");
		System.out.println("[4] - Ver grupos de rock con mas de 3 miembros");
		System.out.println("[0] - Salir");
		System.out.println("Selecciona una opcion:");
		int opcion = Integer.parseInt(br.readLine());
		return opcion;
	}

}
