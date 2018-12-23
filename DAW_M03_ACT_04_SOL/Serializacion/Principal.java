import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Principal {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Empleado> empresa = new ArrayList<Empleado>();
		Empleado e1 = new Empleado("e1", 44, 30000);
		e1.setClave("password");
		Empleado e2 = new Empleado("e2", 33, 25000);
		e2.setClave("12345");
		
		empresa.add(e1);
		empresa.add(e2);
		
		File archivo = new File("Empleados");
		
		//ESCRIBIR EL ARCHIVO
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
		oos.writeObject(empresa);
		oos.close();
		
		//LEER EL ARCHIVO
		ArrayList<Empleado> empresa2 = new ArrayList<Empleado>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
		empresa2 = (ArrayList<Empleado>) ois.readObject();
		ois.close();
		
		System.out.println("Hay un total de " + empresa2.size() + " empleados");
		for(Empleado e: empresa2){
			System.out.println(e);
		}
	}

}
