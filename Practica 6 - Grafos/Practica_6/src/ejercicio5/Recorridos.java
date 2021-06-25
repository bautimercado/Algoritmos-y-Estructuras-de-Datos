package ejercicio5;

import Grafos.*;
import Estructuras.*;

public class Recorridos {
	
	public <T> ListaEnlazadaGenerica<Vertice<T>> dfs(Grafo<T> grafo){
		ListaEnlazadaGenerica<Vertice<T>> listaVertices = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean [] visitados = new boolean[grafo.listaDeVertices().tamanio()+1];
		for (int i = 1; i<=visitados.length; i++) {
			if(!visitados[i])
				this.dfs(i, grafo, listaVertices, visitados);
		}
		return listaVertices;
	}
	
	private <T> void dfs(int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> listaVertices, boolean [] visitados) {
		visitados[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		listaVertices.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if (!visitados[j])
				this.dfs(j, grafo, listaVertices, visitados);
		}
	}
	
	public <T> ListaEnlazadaGenerica<Vertice<T>> bfs(Grafo<T> grafo){
		ListaEnlazadaGenerica<Vertice<T>> listaVertices = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean [] visitados = new boolean[grafo.listaDeVertices().tamanio()+1];
		for (int i=1; i <= grafo.listaDeVertices().tamanio()+1; i++) {
			if (!visitados[i])
				this.bfs(i, grafo, listaVertices, visitados);
		}
		return listaVertices;
	}
	
	private <T> void bfs(int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> listaVertices, boolean [] visitados) {
		//marco el vértice actual como visitado
		visitados[i] = true;
		//lista para adyacencias (aristas) del vértice origen.
		ListaGenerica<Arista<T>> ady = null;
		//cola para el recorrido por niveles
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		cola.encolar(grafo.listaDeVertices().elemento(i));
		
		while(!cola.esVacia()) {
			Vertice<T> v = cola.desencolar();
			listaVertices.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			//trabajo sobre los vértices adyacentes del vértice origen
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				//obtengo la posición del vértice destino de la arista
				int j = arista.verticeDestino().getPosicion();
				if (!visitados[j]) {
					Vertice<T> w = arista.verticeDestino();
					visitados[j] = true;
					cola.encolar(w);
				}
			}
		}
	}
	
}
