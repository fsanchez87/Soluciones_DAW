import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class InsertarPelicula extends JFrame{
	private JTextField tfTitulo;
	private JTextField tfPais;
	private JTextField tfDuracion;
	private JTextField tfGenero;
	private JComboBox comboBox;
	public InsertarPelicula() throws Exception {
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(101, 43, 61, 16);
		getContentPane().add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(174, 37, 151, 28);
		getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(101, 71, 61, 16);
		getContentPane().add(lblDirector);
		
		tfPais = new JTextField();
		tfPais.setBounds(174, 93, 151, 28);
		getContentPane().add(tfPais);
		tfPais.setColumns(10);
		
		ArrayList<String> listaDirectores = Main.baseDatos.listarDirectores();
		String[] directores = new String[listaDirectores.size()];
		for(int i=0;i<directores.length;i++){
			directores[i] = listaDirectores.get(i);
		}
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(directores));
		comboBox.setBounds(174, 67, 151, 27);
		getContentPane().add(comboBox);
		
		JLabel lblPais = new JLabel("País:");
		lblPais.setBounds(101, 99, 61, 16);
		getContentPane().add(lblPais);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(101, 127, 61, 16);
		getContentPane().add(lblDuracion);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(174, 121, 151, 28);
		getContentPane().add(tfDuracion);
		tfDuracion.setColumns(10);
		
		JLabel lblGnero = new JLabel("Género:");
		lblGnero.setBounds(101, 155, 61, 16);
		getContentPane().add(lblGnero);
		
		tfGenero = new JTextField();
		tfGenero.setBounds(174, 149, 151, 28);
		getContentPane().add(tfGenero);
		tfGenero.setColumns(10);
		
		JButton btnCrearPelicula = new JButton("Crear Película");
		btnCrearPelicula.addActionListener(new BtnCrearPeliculaActionListener());
		btnCrearPelicula.setBounds(166, 203, 117, 29);
		getContentPane().add(btnCrearPelicula);
		
		setVisible(true);
		setSize(450, 300);
	}
	private class BtnCrearPeliculaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String titulo = tfTitulo.getText();
			String director = (String) comboBox.getSelectedItem();
			String codigoDirector = Main.baseDatos.obtenerCodigoDirector(director);
			String pais = tfPais.getText();
			int duracion = Integer.parseInt(tfDuracion.getText());
			String genero = tfGenero.getText();
			try {
				Main.baseDatos.insertarPelicula(titulo, codigoDirector, pais, duracion, genero);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			new VentanaPrincipal();
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
