package ejercicio5;

import Grafos.*;
import Estructuras.*;

public class Mapa {
	private Grafo<String> mapaCiudades;
	
	//getters y setters
	public Grafo<String> getMapaCiudades() {
		return mapaCiudades;
	}

	public void setMapaCiudades(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	private Vertice<String> buscarCiudad(String unaCiudad) {
		ListaGenerica<Vertice<String>> lista = this.mapaCiudades.listaDeVertices();
		lista.comenzar();
		while(!lista.fin()) {
			Vertice<String> v = lista.proximo();
			if (v.dato().equals(unaCiudad)) {
				return v;
			}
		}
		return null;
	}
	//inciso a
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		Resultado result = new Resultado(this.mapaCiudades.listaDeVertices().tamanio());
		Vertice<String> vOrigen = this.buscarCiudad(ciudad1);
		Vertice<String> vDestino = this.buscarCiudad(ciudad2);
		result.setCiudad1(ciudad1);
		
		//voy a suponer que ciudad1 y ciudad2 SEGURO existen en el grafo
		this.devolverCamino(result, vOrigen, vDestino);
		
		return result.getCamino();
	}
	//recorrido dfs
	private void devolverCamino(Resultado result, Vertice<String> vOrigen, Vertice<String> vDestino) {
		if (!result.getEncontreCamino()) {
			result.getVisitados()[vOrigen.getPosicion()] = true;
			result.getCamino().agregarFinal(vOrigen.dato());
			if (vOrigen.equals(vDestino)) {
				result.setEncontreCamino(true);
			}
			else {
				ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(vOrigen);
				ady.comenzar();
				while(!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!result.getVisitados()[arista.verticeDestino().getPosicion()]) {
						this.devolverCamino(result, arista.verticeDestino(), vDestino);
					}
				}
			}
		}
		//si no hay camino entre ciudad1 y ciudad2
		if ((!result.getEncontreCamino()) && (vOrigen.dato().equals(result.getCiudad1()))) 
			result.setCamino(null);
		else {
			result.getVisitados()[vOrigen.getPosicion()] = false;
			result.getCamino().eliminarEn(result.getCamino().tamanio()-1);
		}
	}
	//inciso b
	public ListaGenerica<String> devolverCaminoExceptuado(String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
		Resultado result = new Resultado(this.mapaCiudades.listaDeVertices().tamanio());
		result.setCiudad1(ciudad1);
		Vertice<String> vOrigen = this.buscarCiudad(ciudad1);
		Vertice<String> vDestino = this.buscarCiudad(ciudad2);
		
		this.devolverCaminoExceptuado(vOrigen, vDestino, ciudades, result);
		return result.getCamino();
	}
	private void devolverCaminoExceptuado(Vertice<String> vOrigen, Vertice<String> vDestino,
			ListaGenerica<String> ciudades, Resultado result) {
		if ((!result.getEncontreCamino()) && (!ciudades.incluye(vOrigen.dato()))) {
			result.getVisitados()[vOrigen.getPosicion()] = true;
			result.getCamino().agregarFinal(vOrigen.dato());
			if (vOrigen.equals(vDestino)) 
				result.setEncontreCamino(true);
			else {
				ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(vOrigen);
				ady.comenzar();
				while(!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!result.getVisitados()[arista.verticeDestino().getPosicion()]) 
						this.devolverCaminoExceptuado(arista.verticeDestino(), vDestino, ciudades, result);
				}
			}		
		}
		if ((!result.getEncontreCamino()) && (vOrigen.dato().equals(result.getCiudad1()))) {
			result.setCamino(null);
		}
		else {
			result.getVisitados()[vOrigen.getPosicion()] = false;
			result.getCamino().eliminarEn(result.getCamino().tamanio()-1);
		}
	}

	
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		Resultado result = new Resultado(this.mapaCiudades.listaDeVertices().tamanio());
		Vertice<String> vOrigen = this.buscarCiudad(ciudad1);
		Vertice<String> vDestino = this.buscarCiudad(ciudad2);
		result.setCiudad1(ciudad1);
		Integer contadorMin = Integer.MAX_VALUE;
		ListaGenerica<String> caminoMin = null;
		this.caminoMasCorto(vOrigen, vDestino, result, contadorMin, caminoMin);
		
		return caminoMin;
	}
	private void caminoMasCorto(Vertice<String> vOrigen, Vertice<String> vDestino, Resultado result, 
			Integer contadorMin, ListaGenerica<String> caminoMin) {
		result.getVisitados()[vOrigen.getPosicion()] = true;
		result.getCamino().agregarFinal(vOrigen.dato());
		if (vOrigen.equals(vDestino)) {
			result.setEncontreCamino(true);
			if (result.getCamino().tamanio() < contadorMin) {
				contadorMin = result.getCamino().tamanio();
				this.copiarLista(result.getCamino(), caminoMin);
			}
		}
		else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(vOrigen);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!result.getVisitados()[arista.verticeDestino().getPosicion()]) {
					this.caminoMasCorto(arista.verticeDestino(), vDestino, result, contadorMin, caminoMin);
				}
			}
		}
		if ((!result.getEncontreCamino()) && (vOrigen.dato().equals(result.getCiudad1())))
			caminoMin = null;
		else {
			result.getVisitados()[vOrigen.getPosicion()] = false;
			result.getCamino().eliminarEn(result.getCamino().tamanio()-1);
		}
	}
	
	private void copiarLista(ListaGenerica<String> listaAux, ListaGenerica<String> listaMin) {
		for (int i=1; i <= listaMin.tamanio(); i++)
			listaMin.eliminarEn(i);
		for (int i=1; i <= listaAux.tamanio(); i++)
			listaMin.agregarFinal(listaAux.elemento(i));
	}
	
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		Resultado result = new Resultado(this.mapaCiudades.listaDeVertices().tamanio());
		Vertice<String> vOrigen = this.buscarCiudad(ciudad1);
		Vertice<String> vDestino = this.buscarCiudad(ciudad2);
		result.setCiudad1(ciudad1);
		this.caminoSinCargarCombustible(vOrigen, vDestino, result, tanqueAuto);
		
		return result.getCamino();
	}
	private void caminoSinCargarCombustible(Vertice<String> vOrigen, Vertice<String> vDestino,
		Resultado result, int tanqueAuto) {
		if ((!result.getEncontreCamino()) && (tanqueAuto >= 0)) {
			result.getVisitados()[vOrigen.getPosicion()] = true;
			result.getCamino().agregarFinal(vOrigen.dato());
			if (vOrigen.equals(vDestino)) 
				result.setEncontreCamino(true);
			else {
				ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(vOrigen);
				ady.comenzar();
				while(!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!result.getVisitados()[arista.verticeDestino().getPosicion()]) {
						this.caminoSinCargarCombustible(arista.verticeDestino(), vDestino, result, tanqueAuto-arista.peso());
					}
				}
			}
		}
		if ((!result.getEncontreCamino()) && (vOrigen.dato().equals(result.getCiudad1())))
			result.setCamino(null);
		else {
			result.getVisitados()[vOrigen.getPosicion()] = false;
			result.getCamino().eliminarEn(result.getCamino().tamanio()-1);
		}
	}
	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		Resultado result = new Resultado(this.mapaCiudades.listaDeVertices().tamanio());
		result.setCiudad1(ciudad1);
		result.setCapacidadTanque(tanqueAuto);
		
		Vertice<String> vOrigen = this.buscarCiudad(ciudad1);
		Vertice<String> vDestino = this.buscarCiudad(ciudad2);
		
		Integer cantidadCargasMin = Integer.MAX_VALUE;
		ListaGenerica<String> caminoMin = null;
		
		this.caminoConMenorCargaDeCombustible(vOrigen, vDestino, result, cantidadCargasMin, tanqueAuto, caminoMin, 0);
		return caminoMin;
	}
	private void caminoConMenorCargaDeCombustible(Vertice<String> vOrigen, Vertice<String> vDestino,
			Resultado result, Integer cantidadCargasMin, int autoTanque, ListaGenerica<String> caminoMin,
			int cantCargas) {
		result.getVisitados()[vOrigen.getPosicion()] = true;
		result.getCamino().agregarFinal(vOrigen.dato());
		if (autoTanque <= 0) {
			autoTanque = result.getCapacidadTanque();
			cantCargas++;
		}
		if (vOrigen.equals(vDestino)) {
			result.setEncontreCamino(true);
			if (cantCargas < cantidadCargasMin) {
				cantidadCargasMin = cantCargas;
				this.copiarLista(result.getCamino(), caminoMin);
			}
		}
		else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(vOrigen);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!result.getVisitados()[arista.verticeDestino().getPosicion()])
					this.caminoConMenorCargaDeCombustible(arista.verticeDestino(), vDestino, result, cantidadCargasMin, autoTanque-arista.peso(), caminoMin, cantCargas);
			}
		}
		if ((!result.getEncontreCamino()) && (vOrigen.dato().equals(result.getCiudad1())))
			caminoMin = null;
		else {
			result.getVisitados()[vOrigen.getPosicion()] = false;
			result.getCamino().eliminarEn(result.getCamino().tamanio()-1);
		}
	}
	
	
	
}
