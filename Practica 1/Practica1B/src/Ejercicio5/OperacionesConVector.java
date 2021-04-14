package Ejercicio5;

public class OperacionesConVector {
	static int ultimoMaximo;
	static int ultimoMinimo;
	static double ultimoPromedio;
	
	//Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return")
	public int[] maximoMinimoPromedioConReturn (int [] numeros){
		int minimo = Integer.MIN_VALUE;
		int maximo = Integer.MAX_VALUE;
		int total = 0;
		
		for (int i = 0; i < numeros.length; i++){
			int n = numeros[i];
			if (n > maximo)
				maximo = n;
			if (n < minimo)
				minimo = n;
			total = total + numeros[i];
		}
		return new int[] { maximo, minimo, (total/numeros.length) };
	}
	
	//Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de tipo arreglo).
	public void maximoMinimoPromedioConUnObjeto (int [] numeros, Resultado unResultado){
		int minimo = Integer.MIN_VALUE;
		int maximo = Integer.MAX_VALUE;
		double promedio = 0;
		
		for (int i = 0; i < numeros.length; i++){
			int n = numeros[i];
			if (n > maximo)
				maximo = n;
			if (n < minimo)
				minimo = n;
			promedio = promedio + n;
		}
		unResultado.setMaximo(maximo);
		unResultado.setMinimo(minimo);
		unResultado.setPromedio(promedio/numeros.length);
	}
	
	//Devuelva lo pedido sin usar parámetros ni la sentencia "return"
	public void maximoMinimoPromedioConVariablesGlobales (int [] numeros){
		int minimo = Integer.MIN_VALUE;
		int maximo = Integer.MAX_VALUE;
		double promedio = 0;
		
		for (int i = 0; i < numeros.length; i++){
			int n = numeros[i];
			if (n > maximo)
				maximo = n;
			if (n < minimo)
				minimo = n;
			promedio = promedio + n;
		}
		ultimoMaximo = maximo;
		ultimoMinimo = minimo;
		ultimoPromedio = (promedio/numeros.length);
	}


}
