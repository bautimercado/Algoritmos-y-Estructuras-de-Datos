package estructuras;

public class ColaGenerica<T>{
	private ListaEnlazadaGenerica<T> colaGenerica = new ListaEnlazadaGenerica<T>();

	public void encolar (T dato){
		colaGenerica.agregarFinal(dato);
	}

	public T desencolar(){
		colaGenerica.comenzar();
		T elem = colaGenerica.proximo();
		colaGenerica.eliminarEn(1);
		return elem;
	}

	public T tope(){
		return colaGenerica.elemento(1);
	}

	public boolean esVacia(){
		return colaGenerica.esVacia();
	}

}