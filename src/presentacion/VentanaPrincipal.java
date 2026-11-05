package presentacion;

import java.awt.EventQueue;
import controlador.Controlador;
import controlador.IniciarClases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JButton;

public class VentanaPrincipal extends JFrame{

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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 555, 455);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton BotonCrearVertices = new JButton("Crear vertice");
		BotonCrearVertices.setBounds(313, 252, 128, 30);
		getContentPane().add(BotonCrearVertices);
		BotonCrearVertices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.iniciarVentanaCrearVertice();				
			}
		});
		
		JButton BotonCrearArista = new JButton("Crear Arista");
		BotonCrearArista.setBounds(313, 157, 128, 30);
		getContentPane().add(BotonCrearArista);
		getContentPane().add(BotonCrearVertices);
		BotonCrearArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.iniciarVentanaCrearArista();
			}
		});
		
		JButton BotonCrearDominante = new JButton("Buscar Dominante Minimo");
		BotonCrearDominante.setBounds(313, 83, 171, 30);
		getContentPane().add(BotonCrearDominante);
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
}
