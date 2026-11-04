package controlador;

import logica.Algoritmo;
import logica.Grafo;
import presentacion.VentanaPrincipal;
import presentacion.VentanaCrearArista;
import presentacion.VentanaCrearVertice;
import presentacion.VentanaErrorAlCrearVertice;
import presentacion.VentanaErrorVerticeYaExiste;

public class IniciarClases {
	
	public IniciarClases() {
		Algoritmo algoritmo = new Algoritmo();
		Grafo grafo = new Grafo();
		VentanaPrincipal ventanaPrincipal =  new VentanaPrincipal();
		VentanaCrearArista ventanaCrearArista = new VentanaCrearArista();
		VentanaCrearVertice ventanaCrearVertice =  new VentanaCrearVertice();
		VentanaErrorAlCrearVertice ventanaErrorAlCrearVertice = new VentanaErrorAlCrearVertice();
		VentanaErrorVerticeYaExiste ventanaErrorVerticeYaExiste = new VentanaErrorVerticeYaExiste();
		Controlador controlador = new Controlador();
		
		ventanaPrincipal.setControlador(controlador);
		ventanaCrearArista.setControlador(controlador);
		ventanaCrearVertice.setControlador(controlador);
		ventanaErrorAlCrearVertice.setControlador(controlador);
		ventanaErrorVerticeYaExiste.setControlador(controlador);
		algoritmo.setControlador(controlador);
		grafo.setControlador(controlador);
		
		controlador.setVentanaPrincipal(ventanaPrincipal);
		controlador.setVentanaCrearArista(ventanaCrearArista);
		controlador.setVentanaCrearVertice(ventanaCrearVertice);
		controlador.setAlgoritmo(algoritmo);
		controlador.setGrafo(grafo);
		
		controlador.iniciarVentanaPrincipal();
	}
	
}
