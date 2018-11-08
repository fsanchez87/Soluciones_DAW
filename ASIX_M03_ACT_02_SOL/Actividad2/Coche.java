
public class Coche extends Vehiculo{
	private int num_plazas;
	private final double PRECIO_DIA = 1.5;
	
	public Coche(String matricula, int num_plazas) {
		super(matricula);
		this.num_plazas = num_plazas;
	}

	public int getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}

	public double getPRECIO_DIA() {
		return PRECIO_DIA;
	}
	
	public double calculoAlquiler(int dias){
		return super.calculoAlquiler(dias) + (PRECIO_DIA * num_plazas);
	}
}
