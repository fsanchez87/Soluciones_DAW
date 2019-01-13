import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nombre;
		int edad;
		double altura;
		try{
			System.out.println("Introduce nombre del alumno:");
			nombre = br.readLine();
			if(nombre.matches(".*\\d.*")){
				throw new Exception();
			}
			System.out.println("Introduce edad del alumno:");
			edad = Integer.parseInt(br.readLine());
			System.out.println("Introduce altura del alumno:");
			altura = Double.parseDouble(br.readLine());
		}
		catch(NumberFormatException e){
			System.out.println("Formato numérico incorrecto");
		}
		catch(Exception e){
			System.out.println("Formato del nombre incorrecto");
		}
	}

}
