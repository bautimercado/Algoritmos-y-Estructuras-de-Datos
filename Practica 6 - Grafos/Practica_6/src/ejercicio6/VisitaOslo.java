package ejercicio6;

import Estructuras.*;
import Grafos.*;

public class VisitaOslo {
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, 
			int maxTiempo, ListaGenerica<String> lugaresRestringidos){
		ListaGenerica<String> camino = null;
		Vertice<String> vOrigen = this.buscarVertice(lugares, "Ayuntamiento");
		Vertice<String> vDestino = this.buscarVertice(lugares, destino);
		boolean [] visitados = new boolean [lugares.listaDeVertices().tamanio()+1];
		this.paseoEnBici(lugares, maxTiempo, lugaresRestringidos, false, vOrigen, vDestino, visitados, camino);
		return camino;
	}
	
	private void paseoEnBici(Grafo<String> lugares, int maxTiempo, ListaGenerica<String> lugaresRestringidos, 
			Boolean encontre, Vertice<String> vOrigen, Vertice<String> vDestino, boolean [] visitados,
			ListaGenerica<String> camino) {
		//si no encontre un camino, no tengo un lugar restringido y aun tengo tiempo...
		if ((!encontre) && (!this.esRestringido(vOrigen.dato(), lugaresRestringidos)) && (maxTiempo >= 0)) {
			visitados[vOrigen.getPosicion()] = true;
			camino.agregarFinal(vOrigen.dato());
			
			if (vOrigen.equals(vDestino))
				encontre = true;
			else {
				ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(vOrigen);
				ady.comenzar();
				while(!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!visitados[arista.verticeDestino().getPosicion()])
						this.paseoEnBici(lugares, (maxTiempo-arista.peso()), lugaresRestringidos, encontre, arista.verticeDestino(), vDestino, visitados, camino);
				}
			}
		}
		if ((!encontre) && (vOrigen.dato().equals("Ayuntamiento")))
			camino = null;
		else {
			visitados[vOrigen.getPosicion()] = false;
			camino.eliminarEn(camino.tamanio()-1);
		}
	}
	
	private Vertice<String> buscarVertice(Grafo<String> lugares, String lugar){
		ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> unVertice = vertices.proximo();
			if (unVertice.dato().equals(lugar))
				return unVertice;
		}
		return null;
	}
	
	private boolean esRestringido(String lugar, ListaGenerica<String> lugaresRestringidos) {
		lugaresRestringidos.comenzar();
		while (!lugaresRestringidos.fin()) {
			String unLugar = lugaresRestringidos.proximo();
			if (unLugar.equals(lugar))
				return true;
		}
		return false;
	}
}
