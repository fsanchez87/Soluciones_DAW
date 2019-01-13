import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<Trabajo> misTrabajos = new ArrayList<Trabajo>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int opcion = 0;
		do{
			opcion = menu();
			if(opcion==1){
				registrarTrabajo();
			}
			else if(opcion==2){
				aumentarHoras();
			}
			else if(opcion==3){
				aumentaCostePiezas();
			}
			else if(opcion==4){
				finalizarTrabajo();
			}
			else if(opcion==5){
				mostrarTrabajo();
			}
			else if(opcion!=0){
				System.out.println("Opcion incorrecta");
			}
		}while(opcion!=0);
	}

	private static void mostrarTrabajo() throws NumberFormatException, IOException {
		System.out.println("Introduce ID del trabajo que deseas mostrar:");
		int codigo = Integer.parseInt(br.readLine());
		boolean encontrado = false;
		for(int i=0; i<misTrabajos.size() && !encontrado; i++){
			if(misTrabajos.get(i).getId() == codigo){
				encontrado = true;
				System.out.println("ID: " + misTrabajos.get(i).getId());
				System.out.println("Descripción: " + misTrabajos.get(i).getDescripcion());
				System.out.println("Precio: " + misTrabajos.get(i).calcularPrecio());
			}
		}
		if(!encontrado){
			System.out.println("No existe ningún trabajo con este ID");
		}
	}

	private static void finalizarTrabajo() throws NumberFormatException, IOException {
		System.out.println("Introduce ID del trabajo que deseas finalizar:");
		int codigo = Integer.parseInt(br.readLine());
		boolean encontrado = false;
		for(int i=0; i<misTrabajos.size() && !encontrado; i++){
			if(misTrabajos.get(i).getId() == codigo){
				encontrado = true;
				if(misTrabajos.get(i).isFinalizado()){
					System.out.println("Este trabajo ya está finalizado.");
				}
				else{
					System.out.println("El trabajo con ID " + codigo + " se ha finalizado con éxito.");
				}
			}
		}
		if(!encontrado){
			System.out.println("No existe ningún trabajo con este ID");
		}
	}

	private static void aumentaCostePiezas() throws NumberFormatException, IOException {
		System.out.println("Introduce ID del trabajo que deseas modificar:");
		int codigo = Integer.parseInt(br.readLine());
		boolean encontrado = false;
		for(int i=0; i<misTrabajos.size() && !encontrado; i++){
			if(misTrabajos.get(i).getId() == codigo){
				encontrado = true;
				if(misTrabajos.get(i) instanceof Revision){
					System.out.println("El ID introducido pertenece a una revisión. No tiene coste de piezas");
				}
				else{
					if(misTrabajos.get(i).isFinalizado()){
						System.out.println("El trabajo seleccionado está finalizado. No se puede modificar.");
					}
					else{
						System.out.println("Introduce coste de piezas del trabajo " + codigo + ": ");
						double coste = Double.parseDouble(br.readLine());
						if(misTrabajos.get(i) instanceof Chapa){
							((Chapa)misTrabajos.get(i)).setPrecioMaterial(coste + ((Chapa)misTrabajos.get(i)).getPrecioMaterial());
						}
						else{
							((Mecanica)misTrabajos.get(i)).setPrecioMaterial(coste + ((Mecanica)misTrabajos.get(i)).getPrecioMaterial());
						}
					}
				}
			}
		}
		if(!encontrado){
			System.out.println("No existe ningún trabajo con este ID");
		}
		
	}

	private static void aumentarHoras() throws NumberFormatException, IOException {
		System.out.println("Introduce ID del trabajo que deseas modificar:");
		int codigo = Integer.parseInt(br.readLine());
		boolean encontrado = false;
		for(int i=0; i<misTrabajos.size() && !encontrado; i++){
			if(misTrabajos.get(i).getId() == codigo){
				encontrado = true;
				//AQUI SE PODRIA MIRAR SI EL TRABAJO NO ESTÁ FINALIZADO. EL ENUNCIADO NO LO PIDE
				System.out.println("Introduce número de horas del trabajo " + codigo + ": ");
				double horas = Double.parseDouble(br.readLine());
				misTrabajos.get(i).setHoras(horas + misTrabajos.get(i).getHoras());
			}
		}
		if(!encontrado){
			System.out.println("No existe ningún trabajo con este ID");
		}
	}

	private static void registrarTrabajo() throws NumberFormatException, IOException {
		int tipo = 0;
		do{
			System.out.println("*** TIPOS DE TRABAJO ***");
			System.out.println("[1] - Reparación mecánica");
			System.out.println("[2] - Reparación chapa y pintura");
			System.out.println("[3] - Revisión");
			System.out.println("Elige el tipo de trabajo:");
			tipo = Integer.parseInt(br.readLine());
		}while(tipo!=1 && tipo!=2 && tipo!=3);
		System.out.println("Introduce descripción:");
		String descripcion = br.readLine();
		if(tipo==1){
			misTrabajos.add(new Mecanica(0, descripcion, false, 0));
		}
		else if(tipo==2){
			misTrabajos.add(new Chapa(0, descripcion, false, 0));
		}
		else{
			misTrabajos.add(new Revision(0, descripcion, false));
		}
	}

	private static int menu() throws NumberFormatException, IOException {
		int opcion;
		System.out.println("*** MENU PRINCIPAL ***");
		System.out.println("[1] - Registrar trabajo");
		System.out.println("[2] - Aumentar horas");
		System.out.println("[3] - Aumentar coste piezas");
		System.out.println("[4] - Finalizar trabajo");
		System.out.println("[5] - Mostrar trabajo");
		System.out.println("[6] - Salir");
		System.out.println("Elige una opcion:");
		opcion = Integer.parseInt(br.readLine());
		return opcion;
	}

}
