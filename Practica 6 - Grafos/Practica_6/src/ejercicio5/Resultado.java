package ejercicio5;

import Estructuras.*;
import Grafos.*;

public class Resultado {
	private Boolean encontreCamino;
	private ListaGenerica<String> camino;
	private String ciudad1;
	private boolean [] visitados;
	private Integer capacidadTanque;
	
	public Resultado(int tamanio) {
		encontreCamino = false;
		camino = null;
		ciudad1 = null;
		visitados = new boolean [tamanio+1];
		capacidadTanque = 0;
	}

	public Boolean getEncontreCamino() {
		return encontreCamino;
	}

	public void setEncontreCamino(Boolean encontreCamino) {
		this.encontreCamino = encontreCamino;
	}

	public ListaGenerica<String> getCamino() {
		return camino;
	}

	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}

	public String getCiudad1() {
		return ciudad1;
	}

	public void setCiudad1(String ciudad1) {
		this.ciudad1 = ciudad1;
	}

	public boolean[] getVisitados() {
		return visitados;
	}

	public void setVisitados(boolean[] visitados) {
		this.visitados = visitados;
	}

	public Integer getCapacidadTanque() {
		return capacidadTanque;
	}

	public void setCapacidadTanque(Integer capacidadTanque) {
		this.capacidadTanque = capacidadTanque;
	}

	
	

}
