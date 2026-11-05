package presentacion;

import java.awt.EventQueue;
import controlador.Controlador;
import controlador.IniciarClases;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VentanaErrorVerticeNegativo extends JFrame{

	private JFrame frame;
	private Controlador controlador;

	public static void main(String[] args) {
		new IniciarClases();
	}

	public VentanaErrorVerticeNegativo() {
		getContentPane().setLayout(null);
		
		JLabel lblNumeroNegativo = new JLabel("No se pueden crear vértices con números negativos.");
		lblNumeroNegativo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroNegativo.setForeground(Color.RED);
		lblNumeroNegativo.setBounds(10, 11, 421, 32);
		getContentPane().add(lblNumeroNegativo);
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
