package Ejercicio2;

public class Numero {
	
	public static int[] arrN (int n){
		int [] vector = new int [n];
		int aux = n;
		for (int i = 0; i < n; i++){
			vector[i] = aux;
			aux = aux + n;
		}
		
		return vector;
	}
	           
	
}
