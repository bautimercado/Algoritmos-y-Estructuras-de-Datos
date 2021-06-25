package tp04.ejercicio1;


import tp02.ejercicio2.*;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		preOrden(lista);
		return lista;
	}
	
	private void preOrden(ListaEnlazadaGenerica<T> lista) {
		if (!this.esVacio()) {
			lista.agregarFinal(this.getDato());
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			while (!lHijos.fin()) {
				lHijos.proximo().preOrden(lista);
			}
		}
	}
	
	public ListaEnlazadaGenerica<T> inOrden(){
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		inOrden(lista);
		return lista;
	}
	
	private void inOrden(ListaEnlazadaGenerica<T> lista) {
		if (!this.esVacio()) {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			
			if (!lHijos.fin()) {
				lHijos.proximo().inOrden(lista);
			}
			lista.agregarFinal(this.getDato());
			
			while (!lHijos.fin()) {
				lHijos.proximo().inOrden(lista);
			}
		}
	}
	
	public ListaEnlazadaGenerica<T> postOrden(){
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		postOrden(lista);
		return lista;
	}
	
	private void postOrden(ListaEnlazadaGenerica<T> lista) {
		if (!this.esVacio()) {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				lHijos.proximo().postOrden(lista);
			}
			lista.agregarFinal(this.getDato());
		}
	}
	
	public ListaGenerica<T> recorridoPorNiveles(){
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> a = null;
		ListaGenerica<ArbolGeneral<T>> lHijos = null;
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			a = cola.desencolar();
			if (a != null) {
				lista.agregarFinal(a.getDato());
				//para cada hijo del nodo, los encolo
				if (a.tieneHijos()) {
					lHijos = a.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}
			} else
				if (!cola.esVacia()) {
					cola.encolar(null);
					lista.agregarFinal(null);
				}
		}
		return lista;
	}
	
	public int altura() {
		int altura = 1;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> a = null;
		ListaGenerica<ArbolGeneral<T>> lHijos = null;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			a = cola.desencolar();
			if (a != null) {
				if (a.tieneHijos()) {
					lHijos = a.getHijos();
					lHijos.comenzar();
				
					while(!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}
			} else
				if (!cola.esVacia()){
					altura++;
					cola.encolar(null);
				}
		}
		return altura;
	}

	public int nivel(T dato) {
		int profundidad = 1;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> a = null;
		ListaGenerica<ArbolGeneral<T>> lHijos = null;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			a = cola.desencolar();
			if (a != null) {
				if (dato == a.getDato()) {
					return profundidad;
				}
				if (a.tieneHijos()) {
					lHijos = a.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}
			} else
				if (!cola.esVacia()) {
					profundidad ++;
					cola.encolar(null);
				}
		}//-1 si el dato no está en el árbol
		return -1;
	}

	public int ancho() {
		int amplitud = 0;
		int cant_nodos = 0;
		
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> a = null;
		ListaGenerica<ArbolGeneral<T>> lHijos = null;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while(!cola.esVacia()) {
			a = cola.desencolar();
			if (a != null) {
				cant_nodos++;
				if (a.tieneHijos()) {
					lHijos = a.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}
			} else if (!cola.esVacia()) {
				if (amplitud < cant_nodos) 
					amplitud = cant_nodos;
				cant_nodos = 0;
				cola.encolar(null);
			}
		}	
		return amplitud;
	}

	public Boolean esAncestro(T a, T b) {
		//este método determina si un valor a es ancestro de un valor b.
		int camino = 0;
		boolean encontre_a = false;
		ArbolGeneral<T> aux = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ListaGenerica<ArbolGeneral<T>> lHijos = null;
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			
			if (aux != null) {
				if ((aux.getDato() == b) && (!encontre_a))
					return false;
				
				else if (aux.getDato() == b)
					return true;
				
				else if (aux.getDato() == a) 
						encontre_a = true;
				
				if (aux.tieneHijos()) {
					lHijos = aux.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin())
						cola.encolar(lHijos.proximo());
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				if (encontre_a)
					camino++;
			}
		}
		return false;
		
	}



}