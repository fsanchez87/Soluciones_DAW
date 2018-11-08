
public class Furgoneta extends Vehiculo {
	private int pma;
	private final int PRECIO_ANADIDO = 20;
	
	public Furgoneta(String matricula, int pma) {
		super(matricula);
		this.pma = pma;
	}

	public int getPma() {
		return pma;
	}

	public void setPma(int pma) {
		this.pma = pma;
	}

	public int getPRECIO_ANADIDO() {
		return PRECIO_ANADIDO;
	}
	
	public double calculoAlquiler(int dias){
		return super.calculoAlquiler(dias) + (PRECIO_ANADIDO * pma)/10;
	}
}
