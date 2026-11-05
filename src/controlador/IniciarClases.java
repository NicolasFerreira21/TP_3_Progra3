package controlador;

import logica.Algoritmo;
import logica.Grafo;
import presentacion.VentanaPrincipal;
import presentacion.VentanaCrearArista;
import presentacion.VentanaCrearVertice;

public class IniciarClases {
	
	public IniciarClases() {
		Controlador controlador = new Controlador();
		Algoritmo algoritmo = new Algoritmo();
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
		controlador.setAlgoritmo(algoritmo);
		controlador.setGrafo(grafo);
		
		controlador.iniciarVentanaPrincipal();
	}
	
}
