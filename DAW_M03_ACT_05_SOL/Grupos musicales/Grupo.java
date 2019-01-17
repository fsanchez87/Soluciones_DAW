
public class Grupo {
	private String nombre;
	private String estilo;
	private int numIntegrantes;
	public Grupo(String nombre, String estilo, int numIntegrantes) {
		this.nombre = nombre;
		this.estilo = estilo;
		this.numIntegrantes = numIntegrantes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public int getNumIntegrantes() {
		return numIntegrantes;
	}
	public void setNumIntegrantes(int numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}
	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", estilo=" + estilo
				+ ", numIntegrantes=" + numIntegrantes + "]";
	}
}
