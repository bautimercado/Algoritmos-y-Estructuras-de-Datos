package examen;

import estructuras.*;

public class Parcial {
	
	public void colorearArbol(ArbolBinario<String> arbol, Integer n, Integer m) {
		//recorrido por niveles
		int nivel_actual = 0;
		if ((n <= m) && (!arbol.esVacio())) {
			ArbolBinario<String> aux = null;
			ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
			
			cola.encolar(arbol);
			cola.encolar(null);
			
			while (!cola.esVacia()) {
				aux = cola.desencolar();
				
				if (aux != null) {
					if ((n <= nivel_actual) && (nivel_actual <= m)) {
						aux.setDato("Rojo");
					} else {
						aux.setDato("Negro");
					}
					this.encolarHijos(aux, cola);					
				
				} else if (!cola.esVacia()) {
					nivel_actual++;
					cola.encolar(null);
				}
			}
		}
	}
	private void encolarHijos (ArbolBinario<String> aux, ColaGenerica<ArbolBinario<String>> cola) {
		//si aux tiene hijos, los encola en la eedd
		if (aux.tieneHijoIzquierdo()) {
			cola.encolar(aux.getHijoIzquierdo());
		}
		if (aux.tieneHijoDerecho()) {
			cola.encolar(aux.getHijoDerecho());
		}
	}
	
	public static void main (String [] args) {
		Parcial p = new Parcial();
		ArbolBinario<String> raiz = new ArbolBinario<>();
        // h.i de la raiz
        ArbolBinario<String> ab1 = new ArbolBinario<>();

        ArbolBinario<String> ab2 = new ArbolBinario<>();
        ArbolBinario<String> ab3 = new ArbolBinario<>();

        ab1.agregarHijoIzquierdo(ab2);

        ArbolBinario<String> ab4 = new ArbolBinario<>();
        ArbolBinario<String> ab5 = new ArbolBinario<>();
        
        ab2.agregarHijoIzquierdo(ab4);
        ab2.agregarHijoDerecho(ab5);


        ab1.agregarHijoDerecho(ab3);

        ArbolBinario<String> ab6 = new ArbolBinario<>();
        ArbolBinario<String> ab7 = new ArbolBinario<>();

        ab3.agregarHijoIzquierdo(ab6);
        ab3.agregarHijoDerecho(ab7);

        raiz.agregarHijoIzquierdo(ab1);

        // h.d de la raiz
        ArbolBinario<String> ab8 = new ArbolBinario<>();

        ArbolBinario<String> ab9 = new ArbolBinario<>();
        ArbolBinario<String> ab10 = new ArbolBinario<>();

        ab8.agregarHijoIzquierdo(ab9);
        ab8.agregarHijoDerecho(ab10);

        ArbolBinario<String> ab11 = new ArbolBinario<>();
        ArbolBinario<String> ab12 = new ArbolBinario<>();

        ab9.agregarHijoIzquierdo(ab11);
        ab9.agregarHijoDerecho(ab12);

        ArbolBinario<String> ab13 = new ArbolBinario<>();
        ArbolBinario<String> ab14 = new ArbolBinario<>();

        ab10.agregarHijoIzquierdo(ab13);
        ab10.agregarHijoDerecho(ab14);

        raiz.agregarHijoDerecho(ab8);
        
        p.colorearArbol(raiz, 1, 2);
        raiz.recorridoPorNiveles();
	}
}
