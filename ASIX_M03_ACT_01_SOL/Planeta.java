class Planeta{
	//Atributos
	private int identificador;
	private String nombre;
	private double masa;
	private double diametro;
	private double distancia;
	
	//Constructores
	public Planeta(){
	}
	public Planeta(int identificador, String nombre, double masa, double diametro, double distancia){
		setIdentificador(identificador);
		setNombre(nombre);
		setMasa(masa);
		setDiametro(diametro);
		setDistancia(distancia);
	}
	
	//Sets
	public void setIdentificador(int identificador){
		this.identificador = identificador;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setMasa(double masa){
		this.masa = masa;
	}
	public void setDiametro(double diametro){
		this.diametro = diametro;
	}
	public void setDistancia(double distancia){
		this.distancia = distancia;
	}
	
	//Gets
	public int getIdentificador(){
		return this.identificador;
	}
	public String getNombre(){
		return this.nombre;
	}
	public double getMasa(){
		return this.masa;
	}
	public double getDiametro(){
		return this.diametro;
	}
	public double getDistancia(){
		return this.distancia;
	}
}