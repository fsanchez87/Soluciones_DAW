import java.io.*;

public class Equipo {

	public static void main(String[] args) throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Portero jug1 = new Portero();
		jug1.setNombre("Ter Stegen");
		jug1.setDorsal(1);
		jug1.setEquipo("Barcelona");
		jug1.setParadas(9);
		Futbolista jug2 = new Defensa("Pique", 4, "Barcelona", 8);
		Futbolista jug3 = new Delantero("Messi", 10, "Barcelona", 5);
	}

}
