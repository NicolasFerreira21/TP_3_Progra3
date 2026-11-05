package controlador;

import logica.ConjuntoDominante;
import logica.Grafo;
import presentacion.VentanaPrincipal;
import presentacion.VentanaArista;
import presentacion.VentanaVertice;

public class IniciarClases {
	
	public IniciarClases() {
		Controlador controlador = new Controlador();
		ConjuntoDominante ConjuntoDominante = new ConjuntoDominante();
		Grafo grafo = new Grafo();
		VentanaPrincipal ventanaPrincipal =  new VentanaPrincipal();
		VentanaArista ventanaArista = new VentanaArista();
		VentanaVertice ventanaVertice =  new VentanaVertice();
		
		ventanaPrincipal.setControlador(controlador);
		ventanaArista.setControlador(controlador);
		ventanaVertice.setControlador(controlador);
		
		controlador.setVentanaPrincipal(ventanaPrincipal);
		controlador.setVentanaArista(ventanaArista);
		controlador.setVentanaVertice(ventanaVertice);
		controlador.setConjuntoDominante(ConjuntoDominante);
		controlador.setGrafo(grafo);
		
		controlador.iniciarVentanaPrincipal();
	}
	
}
