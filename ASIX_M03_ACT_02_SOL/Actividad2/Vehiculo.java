
public class Vehiculo {
	protected String matricula;
	protected static int PRECIO_BASE=50;
	
	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPRECIO_BASE() {
		return PRECIO_BASE;
	}
	
	public double calculoAlquiler(int dias){
		return PRECIO_BASE * dias;
	}
}
