package logica;

import static org.junit.Assert.assertEquals;
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
	public void testAgregarVerticeInvalidoNegativo() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.agregarVertice(-1));
		assertEquals("El vertice no puede ser menor a cero", excepcion.getMessage());
	}
	
	@Test
	public void testAgregarVerticeInvalidoYaExiste() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.agregarVertice(2));
		assertEquals("El vertice ya existe", excepcion.getMessage());
	}
	
	@Test
	public void testAgregarAristaValido() {
		assertTrue(grafo.existeArista(2, 3));
	}
	
	@Test
	public void testExisteAristaOpuestaValido() {
		assertTrue(grafo.existeArista(3,2));
	}
	
	@Test
	public void testAgregarAristaInvalidoIguales() {
		grafo.agregarVertice(4);
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(4, 4));
		assertEquals("El origen y el destino no deben ser iguales", excepcion.getMessage());
	}
	
	@Test
	public void testAgregarAristaInvalidoOrigenNoExiste() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(4, 2));
		assertEquals("El vertice no existe", excepcion.getMessage());
	}
	
	@Test
	public void testAgregarAristaInvalidoDestinoNoExiste() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(2, 4));
		assertEquals("El vertice no existe", excepcion.getMessage());
	}
	
	
}
