package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import controlador.Controlador;
import controlador.IniciarClases;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VentanaErrorVerticeYaExiste extends JFrame{

	private JFrame frame;
	private Controlador controlador;

	public static void main(String[] args) {
		new IniciarClases();
	}

	public VentanaErrorVerticeYaExiste() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("El vértice ingresado ya existe");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 30, 242, 38);
		getContentPane().add(lblNewLabel);
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
