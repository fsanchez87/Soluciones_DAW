
class Chapa extends Trabajo{
	private double precio_material;
	private static double precio_chapa = 1.3;
	
	public Chapa(){
	}
	
	public Chapa(double horas, String descripcion, boolean finalizado, double precio_material){
		super(horas, descripcion, finalizado);
		setPrecioMaterial(precio_material);
	}
	
	public void setPrecioMaterial(double precio_material){
		this.precio_material = precio_material;
	}
	public double getPrecioMaterial(){
		return this.precio_material;
	}
	
	public double getPrecioChapa(){
		return Chapa.precio_chapa;
	}
	
	public double calcularPrecio(){
		return super.calcularPrecio() + this.precio_material * this.precio_chapa;
	}
}
