package Ejercicio1;

import Listas.*;

public class Ejercicio1_6 {
	
	public int operacion (int n){
		if (n % 2 == 0)
			n = n/2;
		else
			n = (3 * n) + 1;
		return n;
	}
	
	public ListaDeEnterosEnlazada sucesion (int n){
		ListaDeEnterosEnlazada unaLista = n == 1 ? new ListaDeEnterosEnlazada() : sucesion(operacion(n));
		unaLista.agregarInicio(n);
		return unaLista;
	}

	public static void main (String [] args){
		
		Ejercicio1_6 f = new Ejercicio1_6 ();
		
		ListaDeEnterosEnlazada l = f.sucesion(6);
		
		l.comenzar();
		while (!l.fin()){
			System.out.println(l.proximo());
		}
	}

}
