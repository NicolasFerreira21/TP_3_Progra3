package presentacion;

import java.awt.EventQueue;
import controlador.Controlador;
import controlador.IniciarClases;
import logica.Grafo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame{

	private JFrame frame;
	private Controlador controlador;
	private VentanaGrafo ventanaGrafo;

	public void actualizarGrafo(Grafo grafo) {
		ventanaGrafo.setGrafo(grafo);
	}
	
	
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
		ventanaGrafo = new VentanaGrafo();
		ventanaGrafo.setBounds(10, 10, 280 , 350);
		getContentPane().add(ventanaGrafo);
		
		JButton BotonReiniciarGrafo = new JButton("Reiniciar Grafo");
		BotonReiniciarGrafo.setBounds(323, 292, 128, 30);
		getContentPane().add(BotonReiniciarGrafo);
		BotonReiniciarGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.reiniciarGrafo();				
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 565, 473);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton BotonCrearVertices = new JButton("Vertices");
		BotonCrearVertices.setBounds(323, 84, 128, 30);
		getContentPane().add(BotonCrearVertices);
		BotonCrearVertices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.iniciarVentanaCrearVertice();				
			}
		});
		
		JButton BotonCrearArista = new JButton("Aristas");
		BotonCrearArista.setBounds(323, 136, 128, 30);
		getContentPane().add(BotonCrearArista);
		getContentPane().add(BotonCrearVertices);
		BotonCrearArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.iniciarVentanaCrearArista();
			}
		});
		
		JButton BotonCrearDominante = new JButton("Buscar Dominante Minimo");
		BotonCrearDominante.setBounds(323, 33, 183, 30);
		getContentPane().add(BotonCrearDominante);
		BotonCrearDominante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.generarConjuntoDominanateMinimo();;
			}
		});
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public void MensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE );
	}
	
	public void MostrarConjunto(Set<Integer> conjuntoGenerado) {
		JOptionPane.showMessageDialog(this, "El conjunto dominado de tu grafo es: "+conjuntoGenerado.toString() , "Generado", JOptionPane.INFORMATION_MESSAGE );
	}
	
}
