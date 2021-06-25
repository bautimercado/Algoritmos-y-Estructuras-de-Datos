package tp02.ejercicio2;

public class PilaGenerica<T> {
	private ListaEnlazadaGenerica<T> pilaGenerica = new ListaEnlazadaGenerica<T>();
	
	public void apilar (T dato){
		pilaGenerica.agregarInicio(dato);
	}
	
	public T desapilar(){
		pilaGenerica.comenzar();
		T dato = pilaGenerica.proximo();
		pilaGenerica.eliminarEn(1);
		return dato;
	}

	public T tope(){
		return pilaGenerica.elemento(1);
	}

	public boolean esVacia(){
		return pilaGenerica.esVacia();
	}
	
	
}
