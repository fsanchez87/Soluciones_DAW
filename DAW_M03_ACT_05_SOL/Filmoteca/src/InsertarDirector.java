import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class InsertarDirector extends JFrame{
	private JTextField tfNombre;
	private JTextField tfApellidos;
	public InsertarDirector() {
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(120, 76, 66, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(120, 101, 66, 14);
		getContentPane().add(lblApellidos);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(194, 73, 134, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(192, 98, 136, 20);
		getContentPane().add(tfApellidos);
		tfApellidos.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new BtnInsertarActionListener());
		btnInsertar.setBounds(172, 158, 89, 23);
		getContentPane().add(btnInsertar);
		
		setVisible(true);
		setSize(450, 300);
	}
	private class BtnInsertarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre = tfNombre.getText();
			String apellidos = tfApellidos.getText();
			try {
				Main.baseDatos.insertarDirector(nombre, apellidos);
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
