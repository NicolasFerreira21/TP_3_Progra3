package presentacion;

import java.awt.EventQueue;
import controlador.Controlador;

import javax.swing.JFrame;

public class VentanaCrearArista extends JFrame{

	private JFrame frame;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearArista window = new VentanaCrearArista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCrearArista() {
		getContentPane().setLayout(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
}
