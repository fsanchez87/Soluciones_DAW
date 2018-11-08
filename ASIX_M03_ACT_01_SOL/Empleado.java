import java.util.Arrays;


public class Empleado {
	private String nombre;
	private int edad;
	private double sueldo;
	private int[] ventas;
	private static double prima = 1000;
	
	public Empleado() {
	}

	public Empleado(String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		this.ventas = new int[3];
		for(int i=0;i<3;i++){
			this.ventas[i] = 0;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int[] getVentas() {
		return ventas;
	}

	public void setVentas(int[] ventas) {
		this.ventas = ventas;
	}

	public static double getPrima() {
		return prima;
	}

	public static void setPrima(double prima) {
		Empleado.prima = prima;
	}
	
	public double sueldoFinal(){
		int totalVentas = totalVentas();
		if(totalVentas >= 100){
			return this.sueldo + Empleado.prima;
		}
		else{
			return this.sueldo;
		}
	}

	private int totalVentas() {
		int totalVentas = 0;
		for(int i=0;i<3;i++){
			totalVentas += this.ventas[i];
		}
		return totalVentas;
	}

	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldo="
				+ sueldo + ", ventas=" + Arrays.toString(ventas) + "]";
	}
	
	
}
