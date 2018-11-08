class Defensa extends Futbolista{
	private int recuperados;
	
	Defensa(){
	}
	
	Defensa(String nombre, int dorsal, String equipo, int recuperados){
		super(nombre, dorsal, equipo);
		setRecuperados(recuperados);
	}
	
	public void setRecuperados(int recuperados){
		this.recuperados = recuperados;
	}
	
	public int getRecuperados(){
		return this.recuperados;
	}
}
