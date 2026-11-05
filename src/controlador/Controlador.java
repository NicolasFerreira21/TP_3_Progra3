package controlador;

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