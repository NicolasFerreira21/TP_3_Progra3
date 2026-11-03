package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JButton;

public class VentanaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton BotonCrearVertices = new JButton("Crear vertice");
		BotonCrearVertices.setBounds(313, 252, 128, 30);
		frame.getContentPane().add(BotonCrearVertices);
		BotonCrearVertices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearVertice window = new VentanaCrearVertice();
				window.setVisible(true);
				
			}
		});
		
		JButton BotonCrearArista = new JButton("Crear Arista");
		BotonCrearArista.setBounds(313, 157, 128, 30);
		frame.getContentPane().add(BotonCrearArista);
		frame.getContentPane().add(BotonCrearVertices);
		BotonCrearArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearArista window = new VentanaCrearArista();
				window.setVisible(true);
				
			}
		});
		
		JButton BotonCrearDominante = new JButton("Buscar Dominante Minimo");
		BotonCrearDominante.setBounds(313, 83, 171, 30);
		frame.getContentPane().add(BotonCrearDominante);
	}
}
