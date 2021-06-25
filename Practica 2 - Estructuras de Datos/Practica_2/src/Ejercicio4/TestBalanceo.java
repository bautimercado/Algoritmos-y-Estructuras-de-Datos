package Ejercicio4;

import ListasGenericas.*;

public class TestBalanceo {
	
	/* Esta función verifica si los caracteres c1 y c2
	 * se corresponden entre si ("{ }", "[ ]", "( )")
	 * Si por ejemplo "{ )" esta desbalanceado
	 * La funcion NUNCA recibira dos caracteres que abren
	 * Ej : "((" "{{" "[[", etc. . .
	 * */
	public static boolean open_close (char c1, char c2){
		
		if ((c1 == '(') & (c2 == ')'))
			return true;
		if ((c1 == '[') & (c2 == ']'))
			return true;
		if ((c1 == '{') & (c2 == '}'))
			return true;
		
		return false;
	}
	
	/* Esta funcion retorna un booleano indicando si el param. esta balanceado
	 * Recorre el String y si es un caracter que abre, lo agrega a una Pila
	 * Si es un caracter que cierra, desapila el dato de la pila, y los compara
	 * si no se corresponden, la cadena NO es balanceada. . .
	 * */
	public static boolean esBalanceado (String cadena){
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		
		for (int i = 0; i < cadena.length(); i++){
			char c = cadena.charAt(i);
			if ((c == '(') | (c == '[') | (c == '{')){
				pila.apilar(c);
			}
			else
				if (!open_close(pila.desapilar(),c)){
					return false;
				}	
		}
		return true;
	}
	
	public static void main (String [] args){
		String balanceado = "{()[()]}";
		String desbalanceado = "([)]";
	
		System.out.println("1ra Cadena: "+esBalanceado(balanceado));
		System.out.println("2da Cadena: "+esBalanceado(desbalanceado));
	}

}
