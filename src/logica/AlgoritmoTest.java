package logica;


import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AlgoritmoTest {
	
	private Grafo grafo;
	
	@BeforeEach
	public void iniciarGrafo() {
		grafo = new Grafo();
		for (int i=1; i<7; i++ ) {
			grafo.agregarVertice(i);
		}
		grafo.agregarArista(6, 4);
		grafo.agregarArista(4, 5);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(3, 2);
		grafo.agregarArista(2, 5);
		grafo.agregarArista(5, 1);
		grafo.agregarArista(2, 1);
	}
	
	@Test
	public void dominanteTest() {
		Algoritmo resolver= new Algoritmo();		
		Set<Integer>conjuntoD= new HashSet<>();		
		conjuntoD= resolver.conjuntoDominante(grafo);
		assertEquals(conjuntoD.size(), 2);
		assertTrue(conjuntoD.contains(2)||conjuntoD.contains(4));
		
		
	}
}
