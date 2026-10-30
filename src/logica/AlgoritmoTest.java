package logica;


import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AlgoritmoTest {
	
	@Test
	public void dominanteTest() {
		Grafo ejemploTP = new Grafo();
		Algoritmo resolver= new Algoritmo();
		for (int i=1; i<7; i++ )
			ejemploTP.agregarVertice(i);
		ejemploTP.agregarArista(6, 4);
		ejemploTP.agregarArista(4, 5);
		ejemploTP.agregarArista(3, 4);
		ejemploTP.agregarArista(3, 2);
		ejemploTP.agregarArista(2, 5);
		ejemploTP.agregarArista(5, 1);
		ejemploTP.agregarArista(2, 1);
		Set<Integer>conjuntoD= new HashSet<>();
		
		conjuntoD= resolver.conjuntoDominante(ejemploTP);
		assertEquals(conjuntoD.size(), 2);
		assertTrue(conjuntoD.contains(2)||conjuntoD.contains(4));
		
		
	}
}
