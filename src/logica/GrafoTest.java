package logica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

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
	public void testEliminarVerticeValido() {
		grafo.eliminarVertice(2);
		assertFalse(grafo.existeVertice(2));
	}
	
	@Test
	public void testEliminarVerticeInvalidoNoExiste() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.eliminarVertice(4));
		assertEquals("El vertice no existe", excepcion.getMessage());
	}
	
	@Test
	public void testEliminarVerticeInvalidoNegativo() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.eliminarVertice(-4));
		assertEquals("El vertice no puede ser menor a cero", excepcion.getMessage());
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
	
	@Test
	public void testAgregarAristaInvalidoDestinoYaExiste() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista(2, 3));
		assertEquals("La arista que intentas agregar ya existe", excepcion.getMessage());
	}
	
	@Test
	public void testEliminarAristaValido() {
		grafo.eliminarArista(2,3);
		assertFalse(grafo.existeArista(2,3));
	}
	
	@Test
	public void testEliminarAristaInvalidoIguales() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.eliminarArista(2, 2));
		assertEquals("El origen y el destino no deben ser iguales", excepcion.getMessage());
	}
	
	@Test
	public void testEliminarAristaInvalidoNoExiste() {
		grafo.agregarVertice(1);
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.eliminarArista(2, 1));
		assertEquals("La arista que intentas eliminar no existe", excepcion.getMessage());
	}
	
	@Test
	public void testExisteAristaInvalidoOrigenNoExiste() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.existeArista(1,2));
		assertEquals("El vertice no existe", excepcion.getMessage());
	}
	
	@Test
	public void testExisteAristaInvalidoDestinoNoExiste() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.existeArista(2,1));
		assertEquals("El vertice no existe", excepcion.getMessage());
	}
	
	@Test
	public void testExisteAristaInvalidoIguales() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.existeArista(2,2));
		assertEquals("El origen y el destino no deben ser iguales", excepcion.getMessage());
	}
	
	@Test
	public void testExisteAristaInvalidoNoexisteArista() {
		grafo.agregarVertice(4);
		assertFalse(grafo.existeArista(2, 4));
	}
	
	@Test
	public void testExisteVerticeValido() {
		assertTrue(grafo.existeVertice(2));
	}
	
	@Test
	public void testExisteVerticeInvalidoNoExiste() {
		assertFalse(grafo.existeVertice(1));
	}
	
	@Test
	public void testObtenerVerticesValido() {
		Set<Integer> vertices = grafo.obtenerVertices();
		assertEquals(2, vertices.size());
	}
	
	@Test
	public void testObtenerVecinosValido() {
		Set<Integer> vecinos = grafo.obtenerVecinos(2);
		assertEquals(1, vecinos.size());
	}
	
	@Test
	public void testObtenerVecinosInvalidoNegativo() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.obtenerVecinos(-2));
		assertEquals("El vertice no puede ser menor a cero", excepcion.getMessage());
	}	
	
	@Test
	public void testObtenerVecinosInvalidoNoExiste() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> grafo.obtenerVecinos(4));
		assertEquals("El vertice no existe", excepcion.getMessage());
	}	
	
	@Test
	public void testReiniciarGrafo() {
		grafo.reiniciarGrafo();
		assertEquals(0, grafo.obtenerVertices().size());
	}	
	
}
