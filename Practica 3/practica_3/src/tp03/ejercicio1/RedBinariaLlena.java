package tp03.ejercicio1;

import tp02.ejercicio2.*;

public class RedBinariaLlena {
	//asumo que los segundos de cada nodo son nros enteros
	private ArbolBinario<Integer> redBinaria;
	
	public RedBinariaLlena (ArbolBinario<Integer> redBinaria) {
		this.redBinaria = redBinaria;
	}
	
	public int retardoReenvio () {
		return contarSegundos(redBinaria);
	}
	
	private int contarSegundos (ArbolBinario<Integer> redBinaria) {
		//esta funcion usa el recorrido preorden
		if (!redBinaria.esVacio()) {
			if (redBinaria.esHoja()) {
				return redBinaria.getDato();
			} else {
				int hi = redBinaria.getDato();
				int hd = redBinaria.getDato();
				
				if (redBinaria.tieneHijoIzquierdo()) 
					hi += contarSegundos(redBinaria.getHijoIzquierdo());
				if (redBinaria.tieneHijoDerecho()) 
					hd += contarSegundos(redBinaria.getHijoDerecho());
				
				if (hi > hd)
					return hi;
				else
					return hd;
			}
		} else
			return 0;
	}
}
