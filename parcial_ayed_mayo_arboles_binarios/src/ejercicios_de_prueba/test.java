package ejercicios_de_prueba;

import estructuras.*;

public class test {
	public static void main (String [] args) {
		ArbolBinario<Integer> raiz = new ArbolBinario<>(20);
        // h.i de la raiz
        ArbolBinario<Integer> ab1 = new ArbolBinario<>(7);

        ArbolBinario<Integer> ab2 = new ArbolBinario<>(12);
        ArbolBinario<Integer> ab3 = new ArbolBinario<>(6);

        ab1.agregarHijoIzquierdo(ab2);

        ArbolBinario<Integer> ab4 = new ArbolBinario<>(27);
        ArbolBinario<Integer> ab5 = new ArbolBinario<>(38);
        
        ab2.agregarHijoIzquierdo(ab4);
        ab2.agregarHijoDerecho(ab5);


        ab1.agregarHijoDerecho(ab3);

        ArbolBinario<Integer> ab6 = new ArbolBinario<>(13);
        ArbolBinario<Integer> ab7 = new ArbolBinario<>(11);

        ab3.agregarHijoIzquierdo(ab6);
        ab3.agregarHijoDerecho(ab7);

        raiz.agregarHijoIzquierdo(ab1);

        // h.d de la raiz
        ArbolBinario<Integer> ab8 = new ArbolBinario<>(15);

        ArbolBinario<Integer> ab9 = new ArbolBinario<>(1);
        ArbolBinario<Integer> ab10 = new ArbolBinario<>(10);

        ab8.agregarHijoIzquierdo(ab9);
        ab8.agregarHijoDerecho(ab10);

        ArbolBinario<Integer> ab11 = new ArbolBinario<>(12);
        ArbolBinario<Integer> ab12 = new ArbolBinario<>(21);

        ab9.agregarHijoIzquierdo(ab11);
        ab9.agregarHijoDerecho(ab12);

        ArbolBinario<Integer> ab13 = new ArbolBinario<>(40);
        ArbolBinario<Integer> ab14 = new ArbolBinario<>(50);

        ab10.agregarHijoIzquierdo(ab13);
        ab10.agregarHijoDerecho(ab14);

        raiz.agregarHijoDerecho(ab8);
        /*	     	          20
         *  	      7                 15
         *  	 12        6        1         10
         *    27   38   13   11  12   21   40    50
         * */
	}
}
