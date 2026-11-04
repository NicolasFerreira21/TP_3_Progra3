package logica;

import java.util.HashSet;
import java.util.Set;

import controlador.Controlador;

public class Algoritmo {
	
	private Controlador controlador;
	
	public Set<Integer> conjuntoDominante(Grafo grafo){
		Set<Integer>todos_los_vertices = grafo.obtenerVertices();
		Set<Integer>dominados=new HashSet<>();
		Set<Integer>dominante=new HashSet<>();
	
		while (dominados.size()<todos_los_vertices.size()) {
			Integer mejorDominante=null;
			int coberturaMax=-1;
			for (int vertice : todos_los_vertices) {
				if (dominante.contains(vertice)) {
					continue;
				}
				Set<Integer>cobertura=new HashSet<>();
				if (!dominados.contains(vertice)) {
					cobertura.add(vertice);
				}
				for (int vecino : grafo.obtenerVecinos(vertice)) {
					if (!dominados.contains(vecino)) {
						cobertura.add(vecino);
					}
				}
				if (cobertura.size()>coberturaMax) {
					coberturaMax=cobertura.size();
					mejorDominante=vertice;
				}
			}
			if (mejorDominante==null)
				break;
			dominante.add(mejorDominante);
			dominados.add(mejorDominante);
			dominados.addAll(grafo.obtenerVecinos(mejorDominante));

		}
		return dominante;
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
}
