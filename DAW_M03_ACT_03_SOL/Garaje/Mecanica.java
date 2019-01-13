class Mecanica extends Trabajo{
	private double precio_material;
	private static double precio_mecanica = 1.1;
	
	public Mecanica(){
	}
	
	public Mecanica(double horas, String descripcion, boolean finalizado, double precio_material){
		super(horas, descripcion, finalizado);
		setPrecioMaterial(precio_material);
	}
	
	public void setPrecioMaterial(double precio_material){
		this.precio_material = precio_material;
	}
	public double getPrecioMaterial(){
		return this.precio_material;
	}
	
	public double getPrecioMecanica(){
		return Mecanica.precio_mecanica;
	}
	
	public double calcularPrecio(){
		return super.calcularPrecio() + this.precio_material * this.precio_mecanica;
	}
}
