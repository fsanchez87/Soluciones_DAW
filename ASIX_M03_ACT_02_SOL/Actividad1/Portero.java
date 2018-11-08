class Portero extends Futbolista{
	private int paradas;
	
	Portero(){
	}
	
	Portero(String nombre, int dorsal, String equipo, int paradas){
		super(nombre, dorsal, equipo);
		setParadas(paradas);
	}
	
	public void setParadas(int paradas){
		this.paradas = paradas;
	}
	
	public int getParadas(){
		return this.paradas;
	}
}
