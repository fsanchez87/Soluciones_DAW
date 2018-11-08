import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Vehiculo> misVehiculos = new ArrayList<Vehiculo>();
		misVehiculos.add(new Coche("1111BBB", 5));
		misVehiculos.add(new Microbus("2222CCC", 9));
		misVehiculos.add(new Furgoneta("3333DDD", 2000));
		misVehiculos.add(new Camion("4444FFF", 10000));
		
		String matricula;
		int dias;
		int opcion = 0;
		boolean encontrado;
		do{
			encontrado = false;
			System.out.println("*** CALCULO ALQUILER ***");
			System.out.println("Introduce matricula: ");
			matricula = br.readLine();
			for(int i =0; i<misVehiculos.size() && !encontrado; i++){
				if(matricula.equals(misVehiculos.get(i).getMatricula())){
					encontrado = true;
					System.out.println("Introduce dias del alquiler:");
					dias = Integer.parseInt(br.readLine());
					System.out.println("El precio del alquiler es: " + misVehiculos.get(i).calculoAlquiler(dias));
				}
			}
			if(!encontrado){
				System.out.println("La matricula introducida no se encuentra");
			}
			System.out.println("Desea introducir otra matricula? [0 - NO / 1 - SI]");
			opcion = Integer.parseInt(br.readLine());
		}while(opcion!=0);
	}

}
