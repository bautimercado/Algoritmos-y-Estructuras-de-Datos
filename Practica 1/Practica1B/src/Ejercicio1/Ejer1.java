package Ejercicio1;

public class Ejer1 {
	
	public static void numerosConFor (int a, int b){
		if (a < b){
			for (int i = a; i <= b; i++){
				System.out.println(i);
			}
		} else
			System.out.println("a no es menor que b :(");
	}
	public static void numerosConWhile (int a, int b){
		if (a < b){
			int aux = a;
			while (aux <= b){
				System.out.println(aux);
				aux++;
			}
		} else
			System.out.println("a no es menor que b :(");
	}
	public static void numerosSinEstructuraDeControl (int a, int b){
		if (a <= b){
			System.out.println(a);
			a++;
			numerosSinEstructuraDeControl(a,b);
		}
	}


}
