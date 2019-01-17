import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class EliminarPelicula extends JFrame{
	
	private JComboBox comboBox;
	
	public EliminarPelicula() throws Exception {
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ArrayList<String> listaPelis = Main.baseDatos.listarPeliculas();
		String[] peliculas = new String[listaPelis.size()];
		for(int i=0;i<peliculas.length;i++){
			peliculas[i] = listaPelis.get(i);
		}
		comboBox = new JComboBox();
		comboBox.setBounds(101, 59, 248, 27);
		comboBox.setModel(new DefaultComboBoxModel(peliculas));
		getContentPane().add(comboBox);
		
		JLabel lblSeleccionarPelicula = new JLabel("Seleccionar pelicula:");
		lblSeleccionarPelicula.setBounds(164, 31, 122, 16);
		getContentPane().add(lblSeleccionarPelicula);
		
		JButton btnNewButton = new JButton("Eliminar película");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(166, 141, 117, 29);
		getContentPane().add(btnNewButton);
		
		setVisible(true);
		setSize(450, 300);
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String datos = (String)comboBox.getSelectedItem();
				String codigo = Main.baseDatos.obtenerCodigoPelicula(datos);
				Main.baseDatos.eliminarPelicula(codigo);
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
		public void windowClosing(WindowEvent arg0) {
			dispose();
			new VentanaPrincipal();
		}
	}
}
