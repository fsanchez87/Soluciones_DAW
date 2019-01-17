import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestionBDD {
	private static String datosConexion = "jdbc:mysql://localhost/";
	private static String baseDatos = "Filmoteca";
	private static String usuario = "root";
	private static String password = "12345";
	private Connection con;
	
	public GestionBDD(){
		try {
			con = DriverManager.getConnection(datosConexion+"?useSSL=true", usuario, password);
			try {
				//CREO LA BASE DE DATOS SI NO EXISTE
				crearBDD();
				//CREO LAS TABLAS SI NO EXISTEN
				crearTablaAutor();
				crearTablaLibro();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void crearBDD() throws Exception{
		String query = "create database if not exists "+ baseDatos +";";
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			con = DriverManager.getConnection(datosConexion+baseDatos+"?useSSL=true", usuario, password);
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			stmt.close();
		}
	}
	
	private void crearTablaAutor() throws Exception {
		String query = "create table if not exists Director("
				+ "id_director int primary key auto_increment, "
				+ "nombre varchar(100), "
				+ "apellidos varchar(100));";
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			stmt.close();
		}
	}
	
	private void crearTablaLibro() throws Exception {
		String query = "create table if not exists Pelicula("
				+ "id_pelicula int primary key auto_increment, "
				+ "titulo varchar(100), "
				+ "director int, "
				+ "pais varchar(100), "
				+ "duracion int, "
				+ "genero varchar(100), "
				+ "foreign key(director) references Director(id_director));";
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			stmt.close();
		}
	}

	public void insertarDirector(String nombre, String apellidos) throws Exception {
		// Funcion que inserta un nuevo director
		String query = "insert into Director(nombre, apellidos) values('"+nombre+"', '"+apellidos+"');";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			stmt.close();
		}
	}

	public void actualizarDirector(String codigo, String nombre, String apellidos) throws Exception {
		// Funcion que modifica un director
		String query = "update Director set nombre='"+nombre+"', apellidos='"+apellidos+"' where id_director="+codigo+";";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			stmt.close();
		}
	}
	
	public void eliminarDirector(String codigo) throws Exception {
		// Funcion que elimina el director pasado como parametro
		String query = "delete from Director where id_director="+codigo+";";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			stmt.close();
		}
	}
	
	public ArrayList<String> listarDirectores() throws Exception {
		// Funcion que devuelve una lista con los datos de los directores
		ArrayList<String> listaDirectores = new ArrayList<String>();
		String query = "select * from Director;";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				listaDirectores.add(rs.getInt(1)+ " - " + rs.getString(2) + " " + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		return listaDirectores;
	}
	
	public Director obtenerDirector(int codigo) throws Exception {
		// Funcion que devuelve los datos del director con el codigo dado
		Director d = null;
		String query = "select * from Director where id_director="+codigo+";";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				d = new Director(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		return d;
	}
	
	public ArrayList<String> listarDirectoresSinPelis() throws Exception {
		// Funcion que devuelve una lista con los datos de los directores que no tienen películas
		ArrayList<String> listaDirectores = new ArrayList<String>();
		String query = "select * from Director where id_director not in (select distinct(director) from Pelicula);";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				listaDirectores.add(rs.getInt(1)+ " - " + rs.getString(2) + " " + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		return listaDirectores;
	}
	
	public void insertarPelicula(String titulo, String director, String pais, int duracion, String genero) throws Exception {
		// Funcion que inserta una nueva película
		String query = "insert into Pelicula(titulo, director, pais, duracion, genero) values('"+titulo+"', "+director+", '"+pais+"', "+duracion+", '"+genero+"')";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			stmt.close();
		}
	}

	public ArrayList<String> listarPeliculas() throws Exception {
		// Funcion que devuelve una lista con los códigos y los titulos de las películas
		ArrayList<String> listaPeliculas = new ArrayList<String>();
		String query = "select * from Pelicula;";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				listaPeliculas.add(rs.getInt(1)+ " - " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		return listaPeliculas;
	}

	public Pelicula datosPelicula(String codigo) throws Exception {
		// Funcion que devuelve los datos de la película con el código dado
		Pelicula p = null;
		String query = "select * from Pelicula where id_pelicula="+codigo+";";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				p = new Pelicula(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		return p;
	}

	public void actualizarPelicula(int codigo, String titulo, String director, String pais, int duracion, String genero) throws Exception {
		// Funcion que modifica una película
		String query = "update Pelicula set titulo='"+titulo+"', director="+director+", pais='"+pais+"', duracion="+duracion+", genero='"+genero+"' where id_pelicula="+codigo+";";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			stmt.close();
		}
	}

	public void eliminarPelicula(String codigo) throws Exception {
		// Funcion que elimina la película con el código pasado como parámetro
		String query = "delete from Pelicula where id_pelicula="+codigo+";";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			stmt.close();
		}
	}
	
	public ArrayList<String> listarGeneros() throws Exception {
		// Funcion que devuelve una lista con los géneros de las películas
		ArrayList<String> listaGeneros = new ArrayList<String>();
		String query = "select distinct(genero) from Pelicula;";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				listaGeneros.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		return listaGeneros;
	}
	
	public String obtenerCodigoDirector(String datos){
		String delimiter = " - ";
		String[] temp;
		temp = datos.split(delimiter);
		return temp[0];
	}
	
	public String obtenerCodigoPelicula(String datos){
		String delimiter = " - ";
		String[] temp;
		temp = datos.split(delimiter);
		return temp[0];
	}

	public ArrayList<String> realizarBusqueda(String codigoDirector, String genero) throws Exception {
		// Función que devuelve una lista con las películas con el código de director y el género dados
		ArrayList<String> listaPeliculas = new ArrayList<String>();
		String query = "select p.titulo, d.nombre, d.apellidos, p.pais, p.duracion, p.genero from Pelicula p, Director d where p.director=d.id_director";
		if(codigoDirector!=""){
			query = query + " and d.id_director=" + codigoDirector;
		}
		if(genero!=""){
			query = query + " and p.genero='" + genero + "'";
		}
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				listaPeliculas.add(rs.getString(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getString(4)+" - "+rs.getInt(5) + " - "+rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		return listaPeliculas;
	}
	
	public String[] separarDatos(String datos){
		String delimiter = " - ";
		String[] temp;
		temp = datos.split(delimiter);
		return temp;
	}
}
