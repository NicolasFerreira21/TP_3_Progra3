package logica;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class GrafoTest {
	
	@Test
	public void testExisteArista() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarArista(2,3);
		assertTrue(grafo.existeArista(2,3));
	}
	
	@Test
	public void testExisteAristaOpuesta() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarArista(2,3);
		assertTrue(grafo.existeArista(3,2));
	}
	
	@Test
	public void testAristaInexistente() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarArista(2,3);
		assertFalse(grafo.existeArista(1,4));
	}
}
