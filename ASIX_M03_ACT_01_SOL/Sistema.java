import java.io.*;
class Sistema{
	public static void main(String args[]) throws Exception{
		Planeta [] sistema = new Planeta[9];
		int opcion;
		inicializar_planetas(sistema);
		do{
			opcion = menu();
			switch(opcion){
				case 1:
					consultar_planeta(sistema);
					break;
				case 2:
					modificar_planeta(sistema);
					break;
				case 3:
					estadisticas(sistema);
					break;
				case 0:
					break;
				default:
					System.out.println("Opcion incorrecta");
			}
		}while(opcion!=0);
		
	}
	
	static void inicializar_planetas(Planeta [] sistema) throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int i;
		String nombre;
		double masa, diametro, distancia;
		for(i=0;i<sistema.length;i++){
			System.out.println("Introduce nombre del planeta " + i + ":");
			nombre = br.readLine();
			System.out.println("Introduce masa del planeta " + i + ":");
			masa = Double.parseDouble(br.readLine());
			System.out.println("Introduce diametro del planeta " + i + ":");
			diametro = Double.parseDouble(br.readLine());
			System.out.println("Introduce distancia del planeta " + i + ":");
			distancia = Double.parseDouble(br.readLine());
			sistema[i] = new Planeta(nombre, masa, diametro, distancia);
		}
	}
	
	static int menu() throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int opcion;
		System.out.println("");
		System.out.println("*** MENU PRINCIPAL ***");
		System.out.println("======================");
		System.out.println("[1] - Consultar planeta");
		System.out.println("[2] - Modificar planeta");
		System.out.println("[3] - Estadisticas");
		System.out.println("[0] - Salir");
		System.out.println("Elige una opcion:");
		opcion = Integer.parseInt(br.readLine());
		return opcion;
	}
	
	static void consultar_planeta(Planeta [] sistema) throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int i;
		do{
			System.out.println("Introduce el planeta a consultar:");
			i = Integer.parseInt(br.readLine());
			if(i<0 || i>sistema.length){
				System.out.println("Error en el codigo introducido.");
			}
		}while(i<0 || i>sistema.length);
		System.out.println("*** DATOS DEL PLANETA ***");
		System.out.println("=========================");
		System.out.println("Nombre: " + sistema[i].getNombre());
		System.out.println("Masa: " + sistema[i].getMasa());
		System.out.println("Diametro: " + sistema[i].getDiametro());
		System.out.println("Distancia al Sol: " + sistema[i].getDistancia());
	}
	
	static void modificar_planeta(Planeta [] sistema) throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int i;
		String nombre;
		double masa, diametro, distancia;
		do{
			System.out.println("Introduce el planeta a modificar:");
			i = Integer.parseInt(br.readLine());
			if(i<0 || i>sistema.length){
				System.out.println("Error en el codigo introducido.");
			}
		}while(i<0 || i>sistema.length);
		System.out.println("Nombre anterior: " + sistema[i].getNombre());
		System.out.print("Nombre nuevo: ");
		nombre = br.readLine();
		sistema[i].setNombre(nombre);
		System.out.println("Masa anterior: " + sistema[i].getMasa());
		System.out.print("Masa nueva: ");
		masa = Double.parseDouble(br.readLine());
		sistema[i].setMasa(masa);
		System.out.println("Diametro anterior: " + sistema[i].getDiametro());
		System.out.print("Diametro nueva: ");
		diametro = Double.parseDouble(br.readLine());
		sistema[i].setDiametro(diametro);
		System.out.println("Distancia anterior: " + sistema[i].getDistancia());
		System.out.print("Distancia nueva: ");
		distancia = Double.parseDouble(br.readLine());
		sistema[i].setDistancia(distancia);
	}
	
	static void estadisticas(Planeta [] sistema){
		int i;
		double masaMax = 0, diametroMax = 0, distanciaMax = 0;
		int plMasaMax = 0, plDiametroMax = 0, plDistanciaMax = 0;
		double masaMin = 99999999, diametroMin = 99999999, distanciaMin = 99999999;
		int plMasaMin = 0, plDiametroMin = 0, plDistanciaMin = 0;
		for(i=0;i<sistema.length;i++){
			if(masaMax<sistema[i].getMasa()){
				masaMax = sistema[i].getMasa();
				plMasaMax = i;
			}
			if(masaMin>sistema[i].getMasa()){
				masaMin = sistema[i].getMasa();
				plMasaMin = i;
			}
			if(diametroMax<sistema[i].getDiametro()){
				diametroMax = sistema[i].getDiametro();
				plDiametroMax = i;
			}
			if(diametroMin>sistema[i].getDiametro()){
				diametroMin = sistema[i].getDiametro();
				plDiametroMin = i;
			}
			if(distanciaMax<sistema[i].getDistancia()){
				distanciaMax = sistema[i].getDistancia();
				plDistanciaMax = i;
			}
			if(distanciaMin>sistema[i].getDistancia()){
				distanciaMin = sistema[i].getDistancia();
				plDistanciaMin = i;
			}
		}
		System.out.println("El planeta con mas masa es " + sistema[plMasaMax].getNombre() + " con una masa de " + sistema[plMasaMax].getMasa());
		System.out.println("El planeta con menos masa es " + sistema[plMasaMin].getNombre() + " con una masa de " + sistema[plMasaMin].getMasa());
		System.out.println("El planeta con mas diametro es " + sistema[plDiametroMax].getNombre() + " con un diametro de " + sistema[plDiametroMax].getDiametro());
		System.out.println("El planeta con menos diametro es " + sistema[plDiametroMin].getNombre() + " con un diametro de " + sistema[plDiametroMin].getDiametro());
		System.out.println("El planeta mas lejano al Sol es " + sistema[plDistanciaMax].getNombre() + " con una distancia de " + sistema[plDistanciaMax].getDistancia());
		System.out.println("El planeta mas cercano al Sol es " + sistema[plDistanciaMin].getNombre() + " con una distancia de " + sistema[plDistanciaMin].getDistancia());
	}
}