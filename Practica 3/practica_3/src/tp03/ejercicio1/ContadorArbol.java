package tp03.ejercicio1;

import tp02.ejercicio2.*;

public class ContadorArbol {
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol (ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaEnlazadaGenerica<Integer> contarParesInOrden () {
		ListaEnlazadaGenerica<Integer> lista = null;
		recorridoInOrden(arbol, lista);
		
		return lista;
	}

	private void recorridoInOrden(ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> lista) {
		if (a.tieneHijoIzquierdo()) {
			recorridoInOrden(a.getHijoIzquierdo(), lista);
		}
		if (a.getDato() % 2 == 0) {
			lista.agregarFinal(a.getDato());
		}
		if (a.tieneHijoDerecho()) {
			recorridoInOrden(a.getHijoDerecho(), lista);
		}
	}
	
	public ListaEnlazadaGenerica<Integer> contarParesPostOrden (){
		ListaEnlazadaGenerica<Integer> lista = null;
		recorridoPostOrden(arbol, lista);
		
		return lista;
	}

	private void recorridoPostOrden (ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> lista){
		if (a.tieneHijoIzquierdo()) {
			recorridoPostOrden(a.getHijoIzquierdo(), lista);
		}
		if (a.tieneHijoDerecho()) {
			recorridoPostOrden(a.getHijoDerecho(), lista);
		}
		if (a.getDato() % 2 == 0) {
			lista.agregarFinal(a.getDato());
		}
	}
}
