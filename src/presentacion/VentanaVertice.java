package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Controlador;
import controlador.IniciarClases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

public class VentanaVertice extends JFrame{

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
	public VentanaVertice() {	
		initialize();
		
	}

	private void initialize() {
		setBounds(100, 100, 360, 220);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel ingresarVertice = new JLabel("Ingrese el número del vértice:");
		ingresarVertice.setBounds(10, 46, 228, 26);
		getContentPane().add(ingresarVertice);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(248, 49, 50, 20);
		getContentPane().add(spinner);
		
		JButton botonEliminarVertice = new JButton("Eliminar Vertice");
		botonEliminarVertice.setBounds(20, 128, 135, 23);
		getContentPane().add(botonEliminarVertice);
		botonEliminarVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.eliminarVertice((Integer) spinner.getValue());				
			}
		});
		
		JButton botonCrearVertice = new JButton("Crear Vertice");
		botonCrearVertice.setBounds(20, 83, 135, 23);
		getContentPane().add(botonCrearVertice);
		botonCrearVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.crearVertice((Integer) spinner.getValue());				
			}
		});
		
		
		
	}

	public void MensajeAgregado(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Agregado", JOptionPane.INFORMATION_MESSAGE );
	}
	public void MensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE );
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
