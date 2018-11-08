class Delantero extends Futbolista{
	private int goles;
	
	Delantero(){
	}
	
	Delantero(String nombre, int dorsal, String equipo, int goles){
		super(nombre, dorsal, equipo);
		setGoles(goles);
	}
	
	public void setGoles(int goles){
		this.goles = goles;
	}
	
	public int getGoles(){
		return this.goles;
	}
}
