package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controlador.Controlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private Controlador controlador;


	public Menu(Controlador controlador) {
		this.controlador = controlador;
		setTitle("Conjunto Dominante");
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JButton btnCargaManual = new JButton("Cargar grafo manualmente");

		btnCargaManual.setBounds(125, 80, 200, 20);
		btnCargaManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.abrirVentanaVertices();
			}
		});

		getContentPane().add(btnCargaManual);

		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(342, 233, 84, 20);
		getContentPane().add(btnSalir);
	}
}
