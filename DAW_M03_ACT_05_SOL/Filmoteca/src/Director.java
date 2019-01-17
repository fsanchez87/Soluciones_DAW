
public class Director {
	private int idDirector;
	private String nombre;
	private String apellidos;
	
	public Director(int idDirector, String nombre, String apellidos) {
		super();
		this.idDirector = idDirector;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public int getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(int idDirector) {
		this.idDirector = idDirector;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
}
