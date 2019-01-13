import java.util.HashMap;
import java.util.Iterator;

public class Tienda {

	public static void main(String[] args) {
		HashMap<Producto, Integer> map = new HashMap<Producto, Integer>();
		Producto c1 = new Producto("Prod1", 100);
		Producto c2 = new Producto("Prod2", 100); //Aunque tiene el mismo precio, el nombre es distinto, por tanto se insertará en el hashmap
		Producto c3 = new Producto("Prod1", 4); //Producto repetido. Sustituirá al producto añadido anteriormente
		map.put(c1, 10);
		map.put(c2, 4);
		System.out.println(map.size());
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
		    HashMap.Entry e = (HashMap.Entry)it.next();
		    System.out.println(e.getKey() + " Stock: " + e.getValue());
		}
	}

}
