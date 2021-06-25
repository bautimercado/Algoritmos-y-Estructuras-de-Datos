package Ejercicio1;

import Listas.*;

public class Imprimir_recursivo {
	
	public static void imprimirRecursivo (ListaDeEnteros unaLista){
		if (!unaLista.fin()){
			int elem = unaLista.proximo();
			imprimirRecursivo(unaLista);
			System.out.println(elem);
		}
	}

	public static void main (String [] args){
		ListaDeEnterosConArreglos lista_uno = new ListaDeEnterosConArreglos ();
		for (int i = 1; i < 11; i++){
			lista_uno.agregarFinal(i);
		}
		lista_uno.comenzar();
		Imprimir_recursivo.imprimirRecursivo(lista_uno);
		
		ListaDeEnterosEnlazada lista_dos = new ListaDeEnterosEnlazada();
		for (int i = 11; i < 21; i++){
			lista_dos.agregarFinal(i);
		}
		lista_dos.comenzar();
		Imprimir_recursivo.imprimirRecursivo(lista_dos);
	}
	

}
