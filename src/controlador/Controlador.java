package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Parsed;

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
	
	public void setVentanaCrearVertice(VentanaCrearVertice ventanaCrearVertice) {
		this.ventanaCrearVertice = ventanaCrearVertice;
	}

	public void iniciarVentanaPrincipal() {
		ventanaPrincipal.setVisible(true);
	}
	
	public void iniciarVentanaCrearVertice() {
		ventanaCrearVertice.setVisible(true);
	}
	
	public void iniciarVentanaCrearArista() {
		if(grafo.obtenerVertices().size() == 0){
			ventanaPrincipal.MensajeError("No existen vertices para crear aristas");
		}
		ventanaCrearArista.actualizarVertices();
		ventanaCrearArista.setVisible(true);
	}
	
	public List<Integer> obtenerListaDeVertices() {
		Set<Integer> vertices = grafo.obtenerVertices();
		List<Integer> listaVertices = new ArrayList<>(vertices);
		return listaVertices;
	}

	public void crearVertice(Integer vertice) {
		if(grafo.existeVertice(vertice)) {
			ventanaCrearVertice.MensajeError("El vertice ya existe");
			return;
		}try {
			grafo.agregarVertice(vertice);
			ventanaCrearVertice.MensajeAgregado("Vertice agregado con exito");
		} catch (IllegalArgumentException e) {
			ventanaCrearVertice.MensajeError(e.getMessage());
		}
	}
	
	public void crearArista(Integer origen, Integer destino) {
		try {
			grafo.agregarArista(origen, destino);
			ventanaCrearArista.MensajeAgregado("Arista creada con exito");
		}catch (IllegalArgumentException e) {
			ventanaCrearArista.MensajeError(e.getMessage());
		}
	}
	
	public void generarConjuntoDominanateMinimo() {
		algoritmo.conjuntoDominante(grafo);
		ventanaPrincipal.MostrarConjunto(algoritmo.getConjuntoDominante());
	}

	
	
}
