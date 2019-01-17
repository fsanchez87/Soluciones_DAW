import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPrincipal extends JFrame {
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnInsertarPelicula = new JButton("Insertar Película");
		btnInsertarPelicula.addActionListener(new BtnInsertarPeliculaActionListener());
		btnInsertarPelicula.setBounds(60, 45, 139, 29);
		getContentPane().add(btnInsertarPelicula);
		
		JButton btnModificarPelicula = new JButton("Modificar Película");
		btnModificarPelicula.addActionListener(new BtnModificarPeliculaActionListener());
		btnModificarPelicula.setBounds(60, 86, 139, 29);
		getContentPane().add(btnModificarPelicula);
		
		JButton btnEliminarPelicula = new JButton("Eliminar Película");
		btnEliminarPelicula.addActionListener(new BtnEliminarPeliculaActionListener());
		btnEliminarPelicula.setBounds(60, 127, 139, 29);
		getContentPane().add(btnEliminarPelicula);
		
		JButton btnInsertarDirector = new JButton("Insertar Director");
		btnInsertarDirector.addActionListener(new BtnInsertarDirectorActionListener());
		btnInsertarDirector.setBounds(248, 45, 139, 29);
		getContentPane().add(btnInsertarDirector);
		
		JButton btnModificarDirector = new JButton("Modificar Director");
		btnModificarDirector.addActionListener(new BtnModificarDirectorActionListener());
		btnModificarDirector.setBounds(248, 86, 139, 29);
		getContentPane().add(btnModificarDirector);
		
		JButton btnEliminarDirector = new JButton("Eliminar Director");
		btnEliminarDirector.addActionListener(new BtnEliminarDirectorActionListener());
		btnEliminarDirector.setBounds(248, 127, 139, 29);
		getContentPane().add(btnEliminarDirector);
		
		JButton btnListados = new JButton("Listados");
		btnListados.addActionListener(new BtnListadosActionListener());
		btnListados.setBounds(166, 195, 117, 29);
		getContentPane().add(btnListados);
		
		setVisible(true);
		setSize(450, 300);
	}
	private class BtnInsertarPeliculaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				new InsertarPelicula();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnModificarPeliculaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				new ModificarPelicula();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnEliminarPeliculaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				new EliminarPelicula();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnInsertarDirectorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			new InsertarDirector();
		}
	}
	private class BtnModificarDirectorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				new ModificarDirector();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnEliminarDirectorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				new EliminarDirector();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnListadosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			try {
				new Listados();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
