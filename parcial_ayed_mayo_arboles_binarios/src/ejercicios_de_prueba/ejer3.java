package ejercicios_de_prueba;

import estructuras.ArbolBinario;

public class ejer3 {
	
	public Integer resolver(ArbolBinario<Integer> arbol) {
		return this.resolver(arbol, 0);
	}
	private Integer resolver(ArbolBinario<Integer> arbol, int exponente) {
		if (!arbol.esVacio()) {
			int base = arbol.getDato();
			int result = this.potencia(exponente, base);
			arbol.setDato(result);
			if (arbol.esHoja()) {
				return result;
			} else {
				if ((this.esPar(base)) && (arbol.tieneHijoIzquierdo())) {
					return result += this.resolver(arbol.getHijoIzquierdo(), exponente+1);
				} else if ((!this.esPar(base)) && (arbol.tieneHijoDerecho())){
					return result += this.resolver(arbol.getHijoDerecho(), exponente+1);
				}
			}
		}
		return -1;
	}
	private boolean esPar(Integer numero) {
		return numero % 2 == 0;
	}
	private Integer potencia(int exponente, int base) {
		return (int) Math.pow(base, exponente);
	}
}
