package tp03.ejercicio1;

import tp02.ejercicio2.*;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol;
	
	public ProfundidadDeArbolBinario (ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	//recorrido por niveles, preguntar por esto en la practica. . .
	public int sumaElementosProfundidad(int p) {
		//p : profundidad
		ArbolBinario<Integer> a = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>> ();
		
		cola.encolar(arbol);
		cola.encolar(null);
		int nivel = 0;
		int contador = 0;
		
		while (!cola.esVacia()) {
			a = cola.desencolar();
			if (nivel == p)
				contador += a.getDato();
			if ((a != null) && (nivel != p)) {
				if (a.tieneHijoIzquierdo())
					cola.encolar(a.getHijoIzquierdo());
				if (a.tieneHijoDerecho())
					cola.encolar(a.getHijoDerecho());
			} //si a no es distinta de null. . .
			else if (!cola.esVacia()) {
				//si ya termine de contabilizar en la profundidad recibida. . .
				if (++nivel > p)
					return contador;
				else
					cola.encolar(null);
			}
		}
		return contador;
	}
}
