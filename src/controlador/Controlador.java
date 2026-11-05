package controlador;

<<<<<<< HEAD
import modelo.Algoritmo;
import modelo.Grafo;
import vista.CargaArista;
import vista.CargaVertice;
import vista.Menu;

public class Controlador {
	private Menu menu;
	private CargaVertice cargaVertice;
	private CargaArista cargaArista;
	private Grafo grafoP;
	private Algoritmo algoritmoGoloso;
	
	public Controlador() {
		grafoP = new Grafo();
		this.menu = new Menu(this);
		this.menu.setVisible(true);
	}
	public void abrirVentanaVertices() {
		this.menu.dispose();
		cargaVertice = new CargaVertice(this);
		cargaVertice.setVisible(true);
	}
	public void agregarVertice(int vertice){
		try {
			grafoP.agregarVertice(vertice);
			cargaVertice.reiniciarSpinner();
			cargaVertice.MensajeAgregado("El vertice fue agregado con exito");
		}
		catch(IllegalArgumentException e){
			cargaVertice.MensajeError(e.getMessage());
		}
		catch (Exception ex) {
			cargaVertice.MensajeError("El valor ingresado es inválido");
		}
	}
	public void abrirVentanaAristas() {
		if (grafoP.obtenerVertices().isEmpty()) {
			cargaVertice.MensajeError("No hay vertices cargados aun.");
		}
		else if(grafoP.obtenerVertices().size()==1){
			cargaVertice.MensajeError("Hay un solo vertice cargado, no puedes cargar aristas aun.");
		}
		else {
			cargaVertice.dispose();
			cargaArista = new CargaArista(this, grafoP.obtenerVertices());
			cargaArista.setVisible(true);
		}
	}
	public void agregarArista(int origen, int destino){
		try {
			grafoP.agregarArista(origen, destino);
			cargaArista.MensajeAgregado("La arista: ("+origen+", "+destino+") y ("+destino+", "+origen+") fue agregada con éxito");
		}
		catch (IllegalArgumentException e) {
			cargaArista.MensajeError(e.getMessage());
		}
		catch(Exception ex){
			cargaArista.MensajeError("El valor ingresado es inválido");
		}
	}
	public void generarConjuntoDominante() {
		algoritmoGoloso = new Algoritmo();
		cargaArista.MostrarConjunto(algoritmoGoloso.conjuntoDominante(grafoP));
	}
}
=======
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Parsed;

import logica.Algoritmo;
import logica.Grafo;
import presentacion.VentanaPrincipal;
import presentacion.VentanaCrearArista;
import presentacion.VentanaCrearVertice;
import presentacion.VentanaErrorAlCrearVertice;
import presentacion.VentanaErrorVerticeYaExiste;
import presentacion.VentanaErrorVerticeNegativo;

public class Controlador {

	private Algoritmo algoritmo;
	private Grafo grafo;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaCrearArista ventanaCrearArista;
	private VentanaCrearVertice ventanaCrearVertice;
	private VentanaErrorAlCrearVertice ventanaErrorAlCrearVertice;
	private Auxiliar auxiliar = new Auxiliar();
	private VentanaErrorVerticeYaExiste ventanaErrorVerticeYaExiste;
	private VentanaErrorVerticeNegativo ventanaErrorVerticeNegativo;
	
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
	
	public void setVentanaErrorVerticeNegativo(VentanaErrorVerticeNegativo ventanaErrorVerticeNegativo) {
		this.ventanaErrorVerticeNegativo = ventanaErrorVerticeNegativo;
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
	
	private void iniciarVentanaErrorVerticeNegativo() {
		ventanaErrorVerticeNegativo.setVisible(true);
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
		}try {
			grafo.agregarVertice(verticeNum);			
		} catch (IllegalArgumentException e) {
			iniciarVentanaErrorVerticeNegativo();
		}
		
		
	}

	
	
}
>>>>>>> df69c668b237faea98af5eca0e7fe1a387e30b1d
