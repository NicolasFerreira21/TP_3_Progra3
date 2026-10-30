package logica;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GrafoTest {
	
	private Grafo grafo;
	
	@BeforeEach
	public void iniciarGrafo() {
		grafo = new Grafo();
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarArista(2,3);
	}
	
	@Test
	public void testAgregarVerticeValido() {
		grafo.agregarVertice(4);
		assertTrue(grafo.existeVertice(4));
	}
	
	@Test
	public void testAgregarVerticeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> grafo.agregarVertice(-1));
	}
	
	@Test
	public void testAgregarAristaValido() {
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarArista(4, 5);
		assertTrue(grafo.existeArista(4, 5));
	}
	
	@Test
	public void testAgregarAristaInvalidoIguales() {
		grafo.agregarVertice(4);
		assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(4, 4));
	}
	
	@Test
	public void testAgregarAristaInvalidoOrigenNoExiste() {
		assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(4, 2));
	}
	
	@Test
	public void testAgregarAristaInvalidoDestinoNoExiste() {
		assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(2, 4));
	}
	
	@Test
	public void testExisteArista() {
		assertTrue(grafo.existeArista(2,3));
	}
	
	@Test
	public void testExisteAristaOpuestaValido() {
		assertTrue(grafo.existeArista(3,2));
	}
	
}
