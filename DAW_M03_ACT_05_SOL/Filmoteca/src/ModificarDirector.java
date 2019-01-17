import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ModificarDirector extends JFrame{
	
	ArrayList<String> listaDirectores;
	
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JComboBox comboBox;
	
	public ModificarDirector() throws Exception {
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSeleccionaDirector = new JLabel("Selecciona director:");
		lblSeleccionaDirector.setBounds(169, 29, 96, 14);
		getContentPane().add(lblSeleccionaDirector);
		
		listaDirectores = Main.baseDatos.listarDirectores();
		String[] directores = new String[listaDirectores.size()];
		for(int i=0;i<directores.length;i++){
			directores[i] = listaDirectores.get(i);
		}
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(directores));
		comboBox.addItemListener(new ComboBoxItemListener());
		comboBox.setBounds(102, 54, 230, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(119, 99, 69, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(119, 135, 69, 14);
		getContentPane().add(lblApellidos);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(198, 96, 123, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(198, 132, 123, 20);
		getContentPane().add(tfApellidos);
		tfApellidos.setColumns(10);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(172, 190, 89, 23);
		getContentPane().add(btnNewButton);
		
		setVisible(true);
		setSize(450, 300);
	}
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String datosDirector = (String) comboBox.getSelectedItem();
			String codigoDirector = Main.baseDatos.obtenerCodigoDirector(datosDirector);
			String nombre = tfNombre.getText();
			String apellidos = tfApellidos.getText();
			try {
				Main.baseDatos.actualizarDirector(codigoDirector, nombre, apellidos);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			new VentanaPrincipal();
		}
	}
	private class ComboBoxItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent arg0) {
			String datosDirector = (String) comboBox.getSelectedItem();
			String codigoDirector = Main.baseDatos.obtenerCodigoDirector(datosDirector);
			Director d = null;
			try {
				d = Main.baseDatos.obtenerDirector(Integer.parseInt(codigoDirector));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tfNombre.setText(d.getNombre());
			tfApellidos.setText(d.getApellidos());
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
