package logica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private Map<Integer, Set<Integer>> vecindad;
	
	public Grafo() {
		vecindad = new HashMap<>();
	}
	public void agregarVertice(int vertice) {
		if(vertice < 0) {
			throw new IllegalArgumentException("El vertice no puede ser menor a cero");
		}
		vecindad.putIfAbsent(vertice, new HashSet<>());
	}
	public void agregarArista(int origen, int destino) {
		if (!vecindad.containsKey(origen)) {
			throw new IllegalArgumentException("El vertice"+ origen+ "no existe.");
		}
		else if (!vecindad.containsKey(destino)) {
			throw new IllegalArgumentException("El vertice" + destino + "no existe.");
		}
		else if (origen == destino) {
			throw new IllegalArgumentException("El origen y el destino no deben ser iguales");
		}
		else {
			vecindad.get(origen).add(destino);
			vecindad.get(destino).add(origen);
		}
	}
	public boolean existeArista(int i, int j) {
		if (existeVertice(i)) {
			return (vecindad.get(i).contains(j));
		}
		return false;
	}
	public boolean existeVertice(int vertice) {
		return (vecindad.containsKey(vertice));
	}
	public Set<Integer> obtenerVertices (){
		return vecindad.keySet();
	}
	public Set<Integer> obtenerVecinos(int vertice){
		Set<Integer> vecinos = new HashSet<>();
		if (existeVertice(vertice)) {
			vecinos.addAll(vecindad.get(vertice));
		}
			return vecinos;
	}
}
