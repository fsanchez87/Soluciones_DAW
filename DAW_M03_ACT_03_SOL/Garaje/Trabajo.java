class Trabajo{
	private static int numTrabajos = 1;
	private int id;
	private double horas;
	private String descripcion;
	private boolean finalizado;
	private static double precio = 30;
	
	public Trabajo(){
	}
	
	public Trabajo(double horas, String descripcion, boolean finalizado){
		setId(id);
		setHoras(horas);
		setDescripcion(descripcion);
		setFinalizado(finalizado);
	}
	
	public void setId(int id){
		this.id = numTrabajos;
		numTrabajos++;
	}
	
	public void setHoras(double horas){
		this.horas = horas;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public void setFinalizado(boolean finalizado){
		this.finalizado = finalizado;
	}
	
	public int getId(){
		return this.id;
	}
	
	public double getHoras(){
		return this.horas;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public boolean isFinalizado(){
		return this.finalizado;
	}
	
	public double getPrecio(){
		return Trabajo.precio;
	}
	
	public double calcularPrecio(){
		return this.horas * this.precio;
	}

}
