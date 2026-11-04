package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import controlador.Controlador;
import controlador.IniciarClases;

public class VentanaErrorVerticeYaExiste extends JFrame{

	private JFrame frame;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new IniciarClases();
	}

	/**
	 * Create the application.
	 */
	public VentanaErrorVerticeYaExiste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
}
