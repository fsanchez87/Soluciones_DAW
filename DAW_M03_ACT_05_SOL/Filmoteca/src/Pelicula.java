
public class Pelicula {
	private int idPelicula;
	private String titulo;
	private int director;
	private String pais;
	private int duracion;
	private String genero;
	
	public Pelicula(int idPelicula, String titulo, int director, String pais,
			int duracion, String genero) {
		super();
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.director = director;
		this.pais = pais;
		this.duracion = duracion;
		this.genero = genero;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDirector() {
		return director;
	}

	public void setDirector(int director) {
		this.director = director;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo + ", director=" + director + ", pais=" + pais
				+ ", duracion=" + duracion + ", genero=" + genero + "]";
	}
	
	
}
