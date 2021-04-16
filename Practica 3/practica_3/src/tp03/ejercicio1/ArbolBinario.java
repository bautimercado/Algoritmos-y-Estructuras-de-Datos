package tp03.ejercicio1;

import tp02.ejercicio2.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		return false;
	}

	 boolean esCompleto() {
		return false;
	}

	
	// imprime el árbol en preorden  
	public void printPreorden() {
		
	}

	// imprime el �rbol en postorden
	public void printPostorden() {
		
	}


	public void recorridoPorNiveles() {
		
	}

	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();

		return l;
	}

	
	
	
	public int contarHojas() {
		//modulo recursivo que me cuenta la cantidad de hojas que posee un arbol
		int hojas = 0;
		
		//si el arbol no es vacio
		if (!this.esVacio()) {
			//si el arbol no tiene hijos, es una hoja
			if (this.esHoja()) {
				hojas++;
			} else {
				if (this.tieneHijoIzquierdo()) {
					hojas += this.getHijoIzquierdo().contarHojas();
				}
				if (this.tieneHijoDerecho()) {
					hojas += this.getHijoDerecho().contarHojas();
				}
			}
		}
		return hojas;
	}

	public ArbolBinario<T> espejo(){
		if (!this.esVacio()) {
			//creo el arbol espejo y le agrego el dato
			ArbolBinario<T> arbolEspejo = new ArbolBinario<T>();
			arbolEspejo.setDato(this.getDato());
			
			/*si mi instancia de arbol actual tiene hijo izq
			*entonces se lo agrego al hijo derecho del arbol espejo
			*/
			if (this.tieneHijoIzquierdo()) {
				arbolEspejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			}
			//lo mismo para el hijo der.
			if (this.tieneHijoDerecho()) {
				arbolEspejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
			}
			return arbolEspejo;
		}else {
			return null;
		}
	}
	
	public int altura () {
		ArbolBinario<T> a = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int niveles = 0;
		
		while (!cola.esVacia()) {
			a = cola.desencolar();
			
			if (a != null) {
				if (!a.getHijoIzquierdo().esVacio()){
					cola.encolar(a.getHijoIzquierdo());
				}
				if (!a.getHijoDerecho().esVacio()){
					cola.encolar(a.getHijoDerecho());
				}
			} else if (!cola.esVacia()) {
				niveles++;
				//encolar este null es como un "delimitador de niveles"
				cola.encolar(null);
			}
		}
		
		return niveles;
		
	}
	
	public void entreNiveles (int n, int m) {
		if ((0 <= n) && (n < m) && (m <= this.altura())) {
			ArbolBinario<T> a = new ArbolBinario<T>();
			ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
			
			cola.encolar(this);
			cola.encolar(null);
			int nivel = 0;
			
			while (!cola.esVacia()) {
				a = cola.desencolar();
				if (a != null) {
					if ((nivel >= n) && (nivel <= m)) {
						System.out.print(a.getDato());
					}
					if (a.tieneHijoIzquierdo()) {
						cola.encolar(a.getHijoIzquierdo());
					}
					if (a.tieneHijoDerecho()) {
						cola.encolar(a.getHijoDerecho());
					}
			
				} else if (!cola.esVacia()) {
					System.out.println();
					nivel++;
					cola.encolar(null);
				}
			
			} //fin del while
		} //fin del if
	}//fin del metodo

	



}
