class Futbolista {
	private String nombre;
	private int dorsal;
	private String equipo;
	
	Futbolista(){
	}
	
	Futbolista(String nombre, int dorsal, String equipo){
		setNombre(nombre);
		setDorsal(dorsal);
		setEquipo(equipo);
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setDorsal(int dorsal){
		this.dorsal = dorsal;
	}
	
	public void setEquipo(String equipo){
		this.equipo = equipo;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getDorsal(){
		return this.dorsal;
	}
	
	public String getEquipo(){
		return this.equipo;
	}
}
