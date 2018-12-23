import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;


public class Bienvenida extends JFrame{
	public Bienvenida(String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO " + nombre);
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(79, 90, 289, 14);
		getContentPane().add(lblBienvenido);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new BtnCerrarActionListener());
		btnCerrar.setBounds(176, 150, 89, 23);
		getContentPane().add(btnCerrar);
		
		setSize(450, 300);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class BtnCerrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
}
