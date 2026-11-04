package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Controlador;
import controlador.IniciarClases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VentanaCrearVertice extends JFrame{

	private JFrame frame;
	private Controlador controlador;
	private JTextField textoVertice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new IniciarClases();
	}

	/**
	 * Create the application.
	 */
	public VentanaCrearVertice() {
		getContentPane().setLayout(null);
		
		JLabel ingresarVertice = new JLabel("Ingrese el número del vértice a crear:");
		ingresarVertice.setBounds(10, 46, 198, 26);
		getContentPane().add(ingresarVertice);
		
		textoVertice = new JTextField();
		textoVertice.setHorizontalAlignment(SwingConstants.CENTER);
		textoVertice.setBounds(200, 46, 23, 23);
		textoVertice.setText(" ");
		getContentPane().add(textoVertice);
		textoVertice.setColumns(10);
		
		JButton botonCrearVertice = new JButton("Crear Vertice");
		botonCrearVertice.setBounds(10, 113, 118, 23);
		getContentPane().add(botonCrearVertice);
		botonCrearVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.crearVertice(textoVertice.getText());				
			}
		});
		
		JButton botonCerrarVentana = new JButton("Cerrar Ventana");
		botonCerrarVentana.setBounds(10, 160, 118, 23);
		getContentPane().add(botonCerrarVentana);
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
