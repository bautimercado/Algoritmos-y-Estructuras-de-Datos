package tp04.ejercicio1;

import tp02.ejercicio2.*;

public class RedDeAguaPotable {
	private ArbolGeneral<Double> red;
	
	public double minimoCaudal(double caudal) {
		ArbolGeneral<Double> arbol = red;
		ListaEnlazadaGenerica<Double> aux = new ListaEnlazadaGenerica<Double>();
		this.minimoCaudal(caudal, arbol, aux);
		return this.buscarMin(aux);
	}
	private void minimoCaudal(double caudal, ArbolGeneral<Double> arbol, ListaEnlazadaGenerica<Double> aux) {
		if (!arbol.esVacio()) {
			
			if (arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Double>> lHijos = arbol.getHijos();
				lHijos.comenzar();
				
				while(!lHijos.fin()) 
					this.minimoCaudal((caudal/lHijos.tamanio()), lHijos.proximo(), aux);
			} 
			else if (arbol.esHoja()) 
				aux.agregarFinal(caudal);
			
		}
	}
	private double buscarMin(ListaEnlazadaGenerica<Double> lista) {
		double min = 9999;
		lista.comenzar();
		while (!lista.fin()) {
			double aux = lista.proximo();
			if (min > aux)
				min = aux;
		}
		return min;
	}
}