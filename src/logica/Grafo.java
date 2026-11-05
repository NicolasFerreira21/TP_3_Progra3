package logica;

import java.util.HashMap;
import controlador.Controlador;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private Map<Integer, Set<Integer>> vecindad;
	
	public Grafo() {
		vecindad = new HashMap<>();
	}
	
	public void agregarVertice(int vertice) {
		verificarExisteVertice(vertice);
		vecindad.putIfAbsent(vertice, new HashSet<>());
	}
	
	public void agregarArista(int origen, int destino) {
		verificarVertice(origen);
		verificarVertice(destino);
		verificarVerticesDistintos(origen, destino);
		verificarExisteArista(origen, destino);
		vecindad.get(origen).add(destino);
		vecindad.get(destino).add(origen);
	}
	
	public boolean existeArista(int origen, int destino) {
		verificarVertice(origen);
		verificarVertice(destino);
		verificarVerticesDistintos(origen, destino);
		return vecindad.get(origen).contains(destino);
	}
	
	public boolean existeVertice(int vertice) {
		return (vecindad.containsKey(vertice));
	}
	
	public Set<Integer> obtenerVertices (){
		return new HashSet<>(vecindad.keySet());
	}
	
	public Set<Integer> obtenerVecinos(int vertice){
		verificarVertice(vertice);
		Set<Integer> vecinos = new HashSet<>();
		vecinos.addAll(vecindad.get(vertice));
		return vecinos;
	}
	private void verificarExisteVertice(int vertice) {
		if(vertice < 0) {
			throw new IllegalArgumentException("El vertice no puede ser menor a cero.");
		}if(vecindad.containsKey(vertice)) {
			throw new IllegalArgumentException("El vertice ya existe.");
		}
	}
	private void verificarVertice(int vertice) {
		if(vertice < 0) {
			throw new IllegalArgumentException("El vertice no puede ser menor a cero.");
		}if(!vecindad.containsKey(vertice)) {
			throw new IllegalArgumentException("El vertice no existe.");
		}
	}
	
	private void verificarVerticesDistintos(int origen, int destino) {
		if(origen == destino) {
			throw new IllegalArgumentException("El origen y el destino no deben ser iguales.");
		}
	}
	private void verificarExisteArista(int origen, int destino) {
		if(vecindad.get(origen).contains(destino)) {
			throw new IllegalArgumentException("La arista que intentas agregar ya existe.");
		}
	}
	
}
