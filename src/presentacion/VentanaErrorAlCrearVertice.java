package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controlador.Controlador;
import controlador.IniciarClases;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VentanaErrorAlCrearVertice extends JFrame{

	private JFrame frame;
	private Controlador controlador;

	public static void main(String[] args) {
		new IniciarClases();
	}

	public VentanaErrorAlCrearVertice() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("No es válido ingresar letras o palabras, sólo debe ingresar números");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(22, 29, 529, 49);
		getContentPane().add(lblNewLabel);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
