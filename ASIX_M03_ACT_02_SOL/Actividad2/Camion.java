
public class Camion extends Vehiculo {
	private int pma;
	private final int PRECIO_ANADIDO = 20;
	private final int PRECIO_FIJO = 40;
	
	public Camion(String matricula, int pma) {
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

	public int getPRECIO_FIJO() {
		return PRECIO_FIJO;
	}
	
	public double calculoAlquiler(int dias){
		return (PRECIO_BASE * dias) + (PRECIO_ANADIDO * pma) + PRECIO_FIJO;
	}
}
