import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ModificarPelicula extends JFrame{
	private JTextField tfTitulo;
	private JTextField tfPais;
	private JTextField tfDuracion;
	private JTextField tfGenero;
	private JComboBox comboBox;
	private JComboBox cBDirectores;
	private JLabel lblSeleccionaPelicula;
	private JButton btnModificarPelicula;
	
	ArrayList<String> listaDirectores;
	
	public ModificarPelicula() throws Exception {
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ArrayList<String> listaPeliculas = Main.baseDatos.listarPeliculas();
		String[] peliculas = new String[listaPeliculas.size()];
		for(int i=0;i<peliculas.length;i++){
			peliculas[i] = listaPeliculas.get(i);
		}
		comboBox = new JComboBox();
		comboBox.addItemListener(new ComboBoxItemListener());
		comboBox.setBounds(101, 40, 234, 28);
		comboBox.setModel(new DefaultComboBoxModel(peliculas));
		getContentPane().add(comboBox);
		
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(101, 85, 61, 16);
		getContentPane().add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(174, 79, 151, 28);
		getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(101, 113, 61, 16);
		getContentPane().add(lblDirector);
		
		tfPais = new JTextField();
		tfPais.setBounds(174, 135, 151, 28);
		getContentPane().add(tfPais);
		tfPais.setColumns(10);
		
		JLabel lblPais = new JLabel("País:");
		lblPais.setBounds(101, 141, 61, 16);
		getContentPane().add(lblPais);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(101, 169, 61, 16);
		getContentPane().add(lblDuracion);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(174, 163, 151, 28);
		getContentPane().add(tfDuracion);
		tfDuracion.setColumns(10);
		
		JLabel lblGnero = new JLabel("Género:");
		lblGnero.setBounds(101, 197, 61, 16);
		getContentPane().add(lblGnero);
		
		tfGenero = new JTextField();
		tfGenero.setBounds(174, 191, 151, 28);
		getContentPane().add(tfGenero);
		tfGenero.setColumns(10);
		
		listaDirectores = Main.baseDatos.listarDirectores();
		String[] directores = new String[listaDirectores.size()];
		for(int i=0;i<directores.length;i++){
			directores[i] = listaDirectores.get(i);
		}
		cBDirectores = new JComboBox();
		cBDirectores.setBounds(174, 109, 151, 27);
		cBDirectores.setModel(new DefaultComboBoxModel(directores));
		getContentPane().add(cBDirectores);
		
		lblSeleccionaPelicula = new JLabel("Selecciona película:");
		lblSeleccionaPelicula.setBounds(166, 18, 118, 16);
		getContentPane().add(lblSeleccionaPelicula);
		
		btnModificarPelicula = new JButton("Modificar libro");
		btnModificarPelicula.addActionListener(new BtnModificarPeliculaActionListener());
		btnModificarPelicula.setBounds(166, 225, 117, 29);
		getContentPane().add(btnModificarPelicula);
		
		setVisible(true);
		setSize(450, 300);
	}

	private class BtnModificarPeliculaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String pelicula = (String) comboBox.getSelectedItem();
			int codigo = Integer.parseInt(Main.baseDatos.obtenerCodigoPelicula(pelicula));
			String titulo = tfTitulo.getText();
			String director = (String) cBDirectores.getSelectedItem();
			String codigoDirector = Main.baseDatos.obtenerCodigoDirector(director);
			String pais = tfPais.getText();
			int duracion = Integer.parseInt(tfDuracion.getText());
			String genero = tfGenero.getText();
			try {
				Main.baseDatos.actualizarPelicula(codigo, titulo, codigoDirector, pais, duracion, genero);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			new VentanaPrincipal();
		}
	}
	private class ComboBoxItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			String pelicula = (String) comboBox.getSelectedItem();
			String codigo = Main.baseDatos.obtenerCodigoPelicula(pelicula);
			Pelicula p = null;
			try {
				p = Main.baseDatos.datosPelicula(codigo);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tfTitulo.setText(p.getTitulo());
			tfPais.setText(p.getPais());
			tfDuracion.setText(String.valueOf(p.getDuracion()));
			tfGenero.setText(p.getGenero());
			Director director = null;
			try {
				director = Main.baseDatos.obtenerDirector(p.getDirector());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String datosDirector = director.getIdDirector() + " - " + director.getNombre() + " " + director.getApellidos();
			for(int i=0;i<cBDirectores.getItemCount();i++){
				if(((String)cBDirectores.getItemAt(i)).equals(datosDirector)){
					cBDirectores.setSelectedIndex(i);
				}
			}
			for(int i=0;i<listaDirectores.size();i++){
				if(listaDirectores.get(i).equals(datosDirector)){
					cBDirectores.setSelectedIndex(i);
				}
			}
		}
	}
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			dispose();
			new VentanaPrincipal();
		}
	}
}
