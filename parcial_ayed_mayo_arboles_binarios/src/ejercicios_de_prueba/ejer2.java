package ejercicios_de_prueba;

import estructuras.*;

public class ejer2 {
	private ArbolBinario<Integer> arbol;
	
	public Integer buscar() {
		Resultado un_resultado = new Resultado();
		this.buscar(arbol, un_resultado, 0);
		return un_resultado.getResultado();
	}
	private void buscar(ArbolBinario<Integer> arbol, Resultado un_resultado, int nivel) {
		if (!arbol.esVacio()) {
			if (!arbol.esHoja()) {
				if (arbol.tieneHijoIzquierdo()) {
					this.buscar(arbol.getHijoIzquierdo(), un_resultado, nivel+1);
				}
				if (arbol.tieneHijoDerecho()) {
					this.buscar(arbol.getHijoDerecho(), un_resultado, nivel+1);
				}
			} else if (un_resultado.getProfundidad() <= nivel) {
				un_resultado.setProfundidad(nivel);
				un_resultado.setResultado(arbol.getDato());
			}
		}
	}
}
