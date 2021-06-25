package Ejercicio2;

import java.util.Scanner;

public class Contador {
	
	public static int contar42(){
		
		Scanner s = new Scanner(System.in);
		int cantidad = 1;
		
		while (s.nextInt() != 42){
			cantidad++;
		}
		return cantidad;
	}
}
