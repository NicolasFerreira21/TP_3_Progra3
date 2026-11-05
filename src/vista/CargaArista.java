package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Set;

import javax.swing.JTextField;

import controlador.Controlador;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargaArista extends JFrame{

	private Controlador controlador;

	public CargaArista(Controlador controlador, Set<Integer>VerticesCargados) {
		this.controlador=controlador;
		
		setBounds(100, 100, 450, 300);
		setSize(450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCargarArista = new JLabel("Cargar Arista:");
		lblCargarArista.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCargarArista.setBounds(45, 34, 86, 22);
		getContentPane().add(lblCargarArista);
		
		JLabel lblOrigen = new JLabel("Vertice origen:");
		lblOrigen.setBounds(45, 79, 68, 22);
		getContentPane().add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Vertice destino:");
		lblDestino.setBounds(205, 79, 79, 22);
		getContentPane().add(lblDestino);
		
		JComboBox <Integer> Origenes = new JComboBox(VerticesCargados.toArray());
		Origenes.setBounds(45, 111, 68, 20);
		getContentPane().add(Origenes);
		
		JComboBox <Integer> Destinos = new JComboBox(VerticesCargados.toArray());
		Destinos.setBounds(205, 111, 68, 20);
		getContentPane().add(Destinos);
		
		JButton btnCargarArista = new JButton("Cargar");
		btnCargarArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.agregarArista((int) Origenes.getSelectedItem(), (int) Destinos.getSelectedItem());
			}
		});
		btnCargarArista.setBounds(26, 212, 84, 20);
		getContentPane().add(btnCargarArista);
		
		JButton btnGenerarCD = new JButton("Generar");
		btnGenerarCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.generarConjuntoDominante();
			}
		});
		btnGenerarCD.setBounds(185, 212, 84, 20);
		getContentPane().add(btnGenerarCD);
		
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
