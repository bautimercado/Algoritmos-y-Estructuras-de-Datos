package Ejercicio1;


import Listas.*;
import java.util.Scanner;

public class TestListaDeEnterosConArreglos {
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
	
		System.out.println("Ingrese un numero: ");
		int unNumero = sc.nextInt();
		
		while (unNumero != -1){
			lista.agregarInicio(unNumero);
			System.out.println("Ingrese un numero: ");
			unNumero = sc.nextInt();
		}
		lista.comenzar();
		while (!lista.fin()){
			System.out.println(lista.proximo());
		}
		
	}
}
