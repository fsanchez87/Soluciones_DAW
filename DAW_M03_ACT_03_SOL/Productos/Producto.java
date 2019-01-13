
public class Producto {
	private String nombre;
	private int precio;
	public Producto(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		int result = precio + nombre.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Producto other = (Producto) obj;
		if(nombre.equals(other.nombre)) {
			if (precio==(other.precio)){
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public String toString() {
		return "Producto: " + this.nombre + " - " + this.precio;
	}
}
