import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Listados extends JFrame {
	
	ArrayList<String> listaDirectores;
	ArrayList<String> listaGeneros;
	ArrayList<String> listaPeliculas;
	int peliculaActual;
	
	private JComboBox cbDirectores;
	private JComboBox cbGeneros;
	private JTextField tfTitulo;
	private JTextField tfDirector;
	private JTextField tfPais;
	private JTextField tfDuracion;
	private JTextField tfGenero;
	private JLabel lblNoSeHan;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	
	public Listados() throws Exception {
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(10, 11, 46, 14);
		getContentPane().add(lblDirector);
		
		listaDirectores = Main.baseDatos.listarDirectores();
		String[] directores = new String[listaDirectores.size()+1];
		directores[0] = "";
		for(int i=0;i<listaDirectores.size();i++){
			directores[i+1] = listaDirectores.get(i);
		}
		
		cbDirectores = new JComboBox();
		cbDirectores.setBounds(66, 8, 135, 20);
		cbDirectores.setModel(new DefaultComboBoxModel(directores));
		getContentPane().add(cbDirectores);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(221, 11, 46, 14);
		getContentPane().add(lblGnero);
		
		listaGeneros = Main.baseDatos.listarGeneros();
		String[] generos = new String[listaGeneros.size()+1];
		generos[0] = "";
		for(int i=0;i<listaGeneros.size();i++){
			generos[i+1] = listaGeneros.get(i);
		}
		
		cbGeneros = new JComboBox();
		cbGeneros.setBounds(277, 8, 147, 20);
		cbGeneros.setModel(new DefaultComboBoxModel(generos));
		getContentPane().add(cbGeneros);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(172, 39, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblSeleccionaUnCriterio = new JLabel("Selecciona un criterio de b\u00FAsqueda");
		lblSeleccionaUnCriterio.setBounds(121, 73, 216, 14);
		getContentPane().add(lblSeleccionaUnCriterio);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 124, 46, 14);
		getContentPane().add(lblTtulo);
		lblTtulo.setVisible(false);
		
		tfTitulo = new JTextField();
		tfTitulo.setEditable(false);
		tfTitulo.setBounds(66, 121, 135, 20);
		getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		tfTitulo.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Director:");
		lblNewLabel.setBounds(215, 124, 46, 14);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		tfDirector = new JTextField();
		tfDirector.setEditable(false);
		tfDirector.setBounds(277, 121, 147, 20);
		getContentPane().add(tfDirector);
		tfDirector.setColumns(10);
		tfDirector.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("País:");
		lblNewLabel_1.setBounds(10, 160, 46, 14);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		tfPais = new JTextField();
		tfPais.setEditable(false);
		tfPais.setBounds(66, 157, 135, 20);
		getContentPane().add(tfPais);
		tfPais.setColumns(10);
		tfPais.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("P\u00E1ginas:");
		lblNewLabel_2.setBounds(215, 160, 52, 14);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		tfDuracion = new JTextField();
		tfDuracion.setEditable(false);
		tfDuracion.setBounds(277, 157, 147, 20);
		getContentPane().add(tfDuracion);
		tfDuracion.setColumns(10);
		tfDuracion.setVisible(false);
		
		JLabel lblGnero_1 = new JLabel("G\u00E9nero:");
		lblGnero_1.setBounds(10, 193, 46, 14);
		getContentPane().add(lblGnero_1);
		lblGnero_1.setVisible(false);
		
		tfGenero = new JTextField();
		tfGenero.setEditable(false);
		tfGenero.setBounds(66, 190, 135, 20);
		getContentPane().add(tfGenero);
		tfGenero.setColumns(10);
		tfGenero.setVisible(false);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new BtnAnteriorActionListener());
		btnAnterior.setBounds(101, 227, 89, 23);
		getContentPane().add(btnAnterior);
		btnAnterior.setVisible(false);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new BtnSiguienteActionListener());
		btnSiguiente.setBounds(233, 227, 89, 23);
		getContentPane().add(btnSiguiente);
		btnSiguiente.setVisible(false);
		
		setVisible(true);
		setSize(450, 300);
		
		lblNoSeHan = new JLabel("No se han encontrado resultados");
		lblNoSeHan.setBounds(121, 109, 250, 14);
		getContentPane().add(lblNoSeHan);
		lblNoSeHan.setVisible(false);
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			dispose();
			new VentanaPrincipal();
		}
	}
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			peliculaActual = 0;
			String director = (String) cbDirectores.getSelectedItem();
			String codigoDirector = Main.baseDatos.obtenerCodigoDirector(director);
			String genero = (String) cbGeneros.getSelectedItem();
			try {
				listaPeliculas = Main.baseDatos.realizarBusqueda(codigoDirector, genero);
				if(listaPeliculas.size()==0){
					lblNoSeHan.setVisible(true);
					tfTitulo.setVisible(false);
					tfDirector.setVisible(false);
					tfPais.setVisible(false);
					tfDuracion.setVisible(false);
					tfGenero.setVisible(false);
					btnAnterior.setVisible(false);
					btnSiguiente.setVisible(false);
				}
				else{
					String[] datos = Main.baseDatos.separarDatos(listaPeliculas.get(peliculaActual));
					lblNoSeHan.setVisible(false);
					tfTitulo.setText(datos[0]);
					tfTitulo.setVisible(true);
					tfDirector.setText(datos[1]+" "+datos[2]);
					tfDirector.setVisible(true);
					tfPais.setText(datos[3]);
					tfPais.setVisible(true);
					tfDuracion.setText(datos[4]);
					tfDuracion.setVisible(true);
					tfGenero.setText(datos[5]);
					tfGenero.setVisible(true);
					btnAnterior.setVisible(true);
					btnAnterior.setEnabled(false);
					btnSiguiente.setVisible(true);
					if(peliculaActual==listaPeliculas.size()-1){
						btnSiguiente.setEnabled(false);
					}
					else{
						btnSiguiente.setEnabled(true);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private class BtnAnteriorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			peliculaActual--;
			String[] datos = Main.baseDatos.separarDatos(listaPeliculas.get(peliculaActual));
			tfTitulo.setText(datos[0]);
			tfDirector.setText(datos[1]+" "+datos[2]);
			tfPais.setText(datos[3]);
			tfDuracion.setText(datos[4]);
			tfGenero.setText(datos[5]);
			if(peliculaActual==0){
				btnAnterior.setEnabled(false);
				btnSiguiente.setEnabled(true);
			}
			btnSiguiente.setVisible(true);
			btnSiguiente.setEnabled(true);
		}
	}
	private class BtnSiguienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			peliculaActual++;
			String[] datos = Main.baseDatos.separarDatos(listaPeliculas.get(peliculaActual));
			tfTitulo.setText(datos[0]);
			tfDirector.setText(datos[1]+" "+datos[2]);
			tfPais.setText(datos[3]);
			tfDuracion.setText(datos[4]);
			tfGenero.setText(datos[5]);
			if(peliculaActual==listaPeliculas.size()-1){
				btnSiguiente.setEnabled(false);
				btnAnterior.setEnabled(false);
			}
			btnAnterior.setVisible(true);
			btnAnterior.setEnabled(true);
		}
	}
}
