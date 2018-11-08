
public class Microbus extends Vehiculo {
	private int num_plazas;
	private final int PRECIO_PLAZA = 2;
	
	public Microbus(String matricula, int num_plazas) {
		super(matricula);
		this.num_plazas = num_plazas;
	}

	public int getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}

	public int getPRECIO_PLAZA() {
		return PRECIO_PLAZA;
	}
	
	public double calculoAlquiler(int dias){
		return super.calculoAlquiler(dias) + (PRECIO_PLAZA * num_plazas);
	}
}
