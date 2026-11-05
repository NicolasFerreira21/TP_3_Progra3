package controlador;

import logica.ConjuntoDominante;
import logica.Grafo;
import presentacion.VentanaPrincipal;
import presentacion.VentanaCrearArista;
import presentacion.VentanaCrearVertice;

public class IniciarClases {
	
	public IniciarClases() {
		Controlador controlador = new Controlador();
		ConjuntoDominante ConjuntoDominante = new ConjuntoDominante();
		Grafo grafo = new Grafo();
		VentanaPrincipal ventanaPrincipal =  new VentanaPrincipal();
		VentanaCrearArista ventanaCrearArista = new VentanaCrearArista();
		VentanaCrearVertice ventanaCrearVertice =  new VentanaCrearVertice();
		
		ventanaPrincipal.setControlador(controlador);
		ventanaCrearArista.setControlador(controlador);
		ventanaCrearVertice.setControlador(controlador);
		
		controlador.setVentanaPrincipal(ventanaPrincipal);
		controlador.setVentanaCrearArista(ventanaCrearArista);
		controlador.setVentanaCrearVertice(ventanaCrearVertice);

		controlador.iniciarVentanaPrincipal();
	}
	
}
