import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Principal extends JFrame{
	private JTextField nombre;
	private JTextField apellido;
	private JComboBox comboBox;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private ButtonGroup bG;
	private JCheckBox chckbxProgramar;
	private JCheckBox chckbxDeporte;
	private JCheckBox chckbxCine;
	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(88, 32, 46, 14);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(160, 29, 179, 20);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(88, 70, 46, 14);
		getContentPane().add(lblApellido);
		
		apellido = new JTextField();
		apellido.setBounds(160, 67, 179, 20);
		getContentPane().add(apellido);
		apellido.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(88, 113, 46, 14);
		getContentPane().add(lblEdad);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "10-15", "16-20", "21-25", "26-30"}));
		comboBox.setBounds(160, 110, 91, 20);
		getContentPane().add(comboBox);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(88, 148, 46, 14);
		getContentPane().add(lblSexo); 
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(160, 144, 69, 23);
		getContentPane().add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(245, 144, 64, 23);
		getContentPane().add(rdbtnMujer);
		
		bG = new ButtonGroup();
	    bG.add(rdbtnHombre);
	    bG.add(rdbtnMujer);
		
		JLabel lblAficiones = new JLabel("Aficiones");
		lblAficiones.setBounds(88, 185, 59, 14);
		getContentPane().add(lblAficiones);
		
		chckbxProgramar = new JCheckBox("Programar");
		chckbxProgramar.setBounds(154, 181, 91, 23);
		getContentPane().add(chckbxProgramar);
		
		chckbxDeporte = new JCheckBox("Deporte");
		chckbxDeporte.setBounds(245, 181, 82, 23);
		getContentPane().add(chckbxDeporte);
		
		chckbxCine = new JCheckBox("Cine");
		chckbxCine.setBounds(324, 181, 59, 23);
		getContentPane().add(chckbxCine);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setBounds(176, 227, 89, 23);
		getContentPane().add(btnAceptar);
		
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		Principal ventana = new Principal();
		ventana.setSize(450, 300);
		ventana.setVisible(true);
	}
	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JDialog dialog = new JDialog();
			JLabel mensaje;
			if(nombre.getText().isEmpty() || apellido.getText().isEmpty() ||
					comboBox.getSelectedItem().toString().length()==0 || bG.getSelection() == null || 
					(!chckbxProgramar.isSelected() && !chckbxDeporte.isSelected() && !chckbxCine.isSelected())){
				mensaje = new JLabel("Debes introducir todos los datos");
			}
			else{
				mensaje = new JLabel("Gracias por usar la aplicación");
			}
			mensaje.setBounds(88, 148, 46, 14);
			dialog.getContentPane().add(mensaje); 
			dialog.setSize(300,130);
			dialog.setVisible(true);
		}
	}
}
