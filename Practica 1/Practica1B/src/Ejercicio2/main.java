package Ejercicio2;

import java.util.Scanner;

public class main {
	public static void main (String [] args){
		
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un numero: ");
		int n = s.nextInt();
		int [] vector = Numero.arrN(n);
		
		for (int i = 0; i < n; i++){
			System.out.print(vector[i]+" ");
		}
	}
}

