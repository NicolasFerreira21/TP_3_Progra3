package controlador;

import logica.Algoritmo;
import logica.Grafo;
import presentacion.VentanaPrincipal;
import presentacion.VentanaCrearArista;
import presentacion.VentanaCrearVertice;

public class Controlador {

	private Algoritmo algoritmo;
	private Grafo grafo;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaCrearArista ventanaCrearArista;
	private VentanaCrearVertice ventanaCrearVertice;
	
	public void setAlgoritmo(Algoritmo algoritmo) {
		this.algoritmo = algoritmo;
	}
	
	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	public void setVentanaCrearArista(VentanaCrearArista ventanaCrearArista) {
		this.ventanaCrearArista = ventanaCrearArista;
	}
	
	public void setVentanaPrincipal(VentanaCrearVertice ventanaCrearVertice) {
		this.ventanaCrearVertice = ventanaCrearVertice;
	}
	
}
