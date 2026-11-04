package controlador;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Parsed;

import logica.Algoritmo;
import logica.Grafo;
import presentacion.VentanaPrincipal;
import presentacion.VentanaCrearArista;
import presentacion.VentanaCrearVertice;
import presentacion.VentanaErrorAlCrearVertice;
import presentacion.VentanaErrorVerticeYaExiste;

public class Controlador {

	private Algoritmo algoritmo;
	private Grafo grafo;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaCrearArista ventanaCrearArista;
	private VentanaCrearVertice ventanaCrearVertice;
	private VentanaErrorAlCrearVertice ventanaErrorAlCrearVertice;
	private Auxiliar auxiliar;
	private VentanaErrorVerticeYaExiste ventanaErrorVerticeYaExiste;
	
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
	
	public void setVentanaErrorAlCrearVertice(VentanaErrorAlCrearVertice ventanaErrorAlCrearVertice) {
		this.ventanaErrorAlCrearVertice = ventanaErrorAlCrearVertice;
	}
	
	public void setVentanaErrorVerticeYaExiste(VentanaErrorVerticeYaExiste ventanaErrorVerticeYaExiste) {
		this.ventanaErrorVerticeYaExiste = ventanaErrorVerticeYaExiste;
	}

	public void iniciarVentanaPrincipal() {
		ventanaPrincipal.setVisible(true);
	}
	
	public void iniciarVentanaCrearVertice() {
		ventanaCrearVertice.setVisible(true);
	}
	
	public void iniciarVentanaCrearArista() {
		ventanaCrearArista.setVisible(true);
	}
	
	private void iniciarVentanaErrorAlCrearVertice() {
		ventanaErrorAlCrearVertice.setVisible(true);
	}
	
	private void iniciarVentanaErrorVerticeYaExiste() {
		ventanaErrorVerticeYaExiste.setVisible(true);
	}

	public void crearVertice(String vertice) {
		if(!auxiliar.esNumero(vertice)) {
			iniciarVentanaErrorAlCrearVertice();
			return;
		}
		int verticeNum = Integer.parseInt(vertice);
		if(grafo.existeVertice(verticeNum)) {
			iniciarVentanaErrorVerticeYaExiste();
			return;
		}
		grafo.agregarVertice(verticeNum);
		
	}

	
	
}
