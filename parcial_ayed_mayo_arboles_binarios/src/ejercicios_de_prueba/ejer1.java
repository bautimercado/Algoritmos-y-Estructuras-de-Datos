package ejercicios_de_prueba;

import estructuras.*;

public class ejer1 {

	public ListaEnlazadaGenerica<Integer> resolver (ArbolBinario<Integer> arbol) {
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		this.resolver(arbol, lista);
		return lista;
	}
	
	private void resolver (ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> lista) {
		if (!arbol.esVacio()) {
			int cant_hi = this.contarDescendientes(arbol.getHijoIzquierdo());
			int cant_hd = this.contarDescendientes(arbol.getHijoDerecho());
			if (cant_hi == cant_hd) {
				lista.agregarFinal(arbol.getDato());
			}
			if (arbol.tieneHijoIzquierdo()) {
				this.resolver(arbol.getHijoIzquierdo(), lista);
			}
			if (arbol.tieneHijoDerecho()) {
				this.resolver(arbol.getHijoDerecho(), lista);
			}
			
		}
	}
	
	private int contarDescendientes(ArbolBinario<Integer> arbol) {
		if (arbol.esVacio()) {
			return 0;
		} else {
			int aux = 1;
			if (arbol.tieneHijoIzquierdo()) {
				aux += this.contarDescendientes(arbol.getHijoIzquierdo());
			}
			if (arbol.tieneHijoDerecho()) {
				aux += this.contarDescendientes(arbol.getHijoDerecho());
			}
			return aux;
		}
	}
}
