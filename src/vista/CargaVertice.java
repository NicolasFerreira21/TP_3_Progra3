package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class CargaVertice extends JFrame{

	private Controlador controlador;
	private SpinnerNumberModel valoresAceptados;

	public CargaVertice(Controlador controlador) {
		this.controlador = controlador;
		setBounds(100, 100, 450, 300);
		setSize(450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblVerticeNuevo = new JLabel("Agregue un vertice:");
		lblVerticeNuevo.setBounds(174, 51, 96, 18);
		getContentPane().add(lblVerticeNuevo);
		
		valoresAceptados = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		JSpinner spinner = new JSpinner(valoresAceptados);
		spinner.setBounds(184, 78, 58, 20);
		getContentPane().add(spinner);
		
		JButton btnCargarVerticeNuevo = new JButton("Cargar");
		btnCargarVerticeNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.agregarVertice((int) spinner.getValue());	
				}
		});
		btnCargarVerticeNuevo.setBounds(44, 137, 84, 20);
		getContentPane().add(btnCargarVerticeNuevo);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.abrirVentanaAristas();
			}
		});
		btnContinuar.setBounds(186, 137, 84, 20);
		getContentPane().add(btnContinuar);
	}


	public void MensajeAgregado(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Agregado", JOptionPane.INFORMATION_MESSAGE );
	}
	public void MensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE );
	}
	public void reiniciarSpinner() {
		valoresAceptados.setValue(0);
	}
}
