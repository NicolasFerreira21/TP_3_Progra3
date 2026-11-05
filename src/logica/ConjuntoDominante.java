package logica;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoDominante {
	
	private Set<Integer> conDominante;
	
	public void obtenerConjuntoDominante(Grafo grafo){
		Set<Integer>todos_los_vertices = grafo.obtenerVertices();
		Set<Integer>dominados = new HashSet<>();
		conDominante = new HashSet<>();
	
		while (dominados.size()<todos_los_vertices.size()) {
			Integer mejorDominante=null;
			int coberturaMax=-1;
			for (int vertice : todos_los_vertices) {
				if (conDominante.contains(vertice)) {
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
			conDominante.add(mejorDominante);
			dominados.add(mejorDominante);
			dominados.addAll(grafo.obtenerVecinos(mejorDominante));
		}

	}
	
	public Set<Integer> getConjuntoDominante(){
		return new HashSet<>(conDominante);
	}
	
}
