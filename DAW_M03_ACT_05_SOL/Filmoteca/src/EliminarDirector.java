import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EliminarDirector extends JFrame{
	
	private JComboBox comboBox;
	
	public EliminarDirector() throws Exception {
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSeleccionaDirector = new JLabel("Selecciona director:");
		lblSeleccionaDirector.setBounds(173, 31, 88, 14);
		getContentPane().add(lblSeleccionaDirector);
		
		ArrayList<String> listaDirectores = Main.baseDatos.listarDirectoresSinPelis();
		String[] directores = new String[listaDirectores.size()];
		for(int i=0;i<directores.length;i++){
			directores[i] = listaDirectores.get(i);
		}
		
		comboBox = new JComboBox();
		comboBox.setBounds(101, 81, 232, 20);
		comboBox.setModel(new DefaultComboBoxModel(directores));
		getContentPane().add(comboBox);
		
		JLabel lblSoloSeMuestran = new JLabel("Solo se muestran directores que no tienen películas");
		lblSoloSeMuestran.setBounds(101, 56, 232, 14);
		getContentPane().add(lblSoloSeMuestran);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setBounds(172, 131, 89, 23);
		getContentPane().add(btnEliminar);
		
		setVisible(true);
		setSize(450, 300);
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			dispose();
			new VentanaPrincipal();
		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String datosDirector = (String) comboBox.getSelectedItem();
			String codigoDirector = Main.baseDatos.obtenerCodigoDirector(datosDirector);
			try {
				Main.baseDatos.eliminarDirector(codigoDirector);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			new VentanaPrincipal();
		}
	}
}
