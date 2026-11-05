package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import controlador.Controlador;
import controlador.IniciarClases;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;

public class VentanaArista extends JFrame{

	private JFrame frame;
	private Controlador controlador;
	private JSpinner spinnerOrigen;
	private JSpinner spinnerDestino;

	public void actualizarVertices() {
		List<Integer> vertices = controlador.obtenerListaDeVertices();
		spinnerOrigen.setModel(new SpinnerListModel(vertices));
		spinnerDestino.setModel(new SpinnerListModel(vertices));
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
	public VentanaArista() {
		initialize();

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 250, 270);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lbVerticeOrigen = new JLabel("Ingrese el vertice de origen:");
		lbVerticeOrigen.setBounds(10, 11, 190, 14);
		getContentPane().add(lbVerticeOrigen);
		
		spinnerOrigen = new JSpinner();
		spinnerOrigen.setBounds(20, 36, 42, 20);
		getContentPane().add(spinnerOrigen);
		
		JLabel lbVerticeDestino = new JLabel("Ingrese el vertice de destino:");
		lbVerticeDestino.setBounds(10, 76, 190, 14);
		getContentPane().add(lbVerticeDestino);
		
		spinnerDestino = new JSpinner();
		spinnerDestino.setBounds(20, 101, 42, 20);
		getContentPane().add(spinnerDestino);
		
		JButton btnCrearArista = new JButton("Crear arista");
		btnCrearArista.setBounds(10, 132, 125, 23);
		getContentPane().add(btnCrearArista);
		btnCrearArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.crearArista((Integer)spinnerOrigen.getValue(), (Integer) spinnerDestino.getValue());				
			}
		});
		
		JButton btnEliminarArista = new JButton("Eliminar arista");
		btnEliminarArista.setBounds(10, 166, 125, 23);
		getContentPane().add(btnEliminarArista);
		btnEliminarArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.eliminarArista((Integer)spinnerOrigen.getValue(), (Integer) spinnerDestino.getValue());				
			}
		});

	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public void MensajeAgregado(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Agregado", JOptionPane.INFORMATION_MESSAGE );
	}
	public void MensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE );
	}
	public void MostrarConjunto(Set<Integer> conjuntoGenerado) {
		JOptionPane.showMessageDialog(this, "El conjunto dominado de tu grafo es: "+conjuntoGenerado.toString() , "Generado", JOptionPane.INFORMATION_MESSAGE );
	}
	
	
}
