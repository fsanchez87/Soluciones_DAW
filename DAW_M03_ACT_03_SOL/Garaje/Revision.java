class Revision extends Trabajo{
	
	private static double precio_extra = 20;
	
	public Revision(){
	}
	
	public Revision(double horas, String descripcion, boolean finalizado){
		super(horas, descripcion, finalizado);
	}
	
	public double getPrecioExtra(){
		return Revision.precio_extra;
	}
	
	public double calcularPrecio(){
		return super.calcularPrecio() + this.precio_extra;
	}
}
