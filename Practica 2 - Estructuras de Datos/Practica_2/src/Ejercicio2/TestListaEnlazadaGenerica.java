package Ejercicio2;

import java.util.Scanner;
import ListasGenericas.*;

public class TestListaEnlazadaGenerica {
	public static void main (String [] args){
		/*como la lista es generica, debo aclarar de que tipo 
		 es la lista, en el encabezado de la clase esta nombreClase<T>
		 y en el main debe ir nombreClase<TipoDeDato>
		 puede ser un objeto o una clase wrapper
		*/
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++){
			Estudiante unEstudiante = new Estudiante();
			System.out.println("Ingrese nombre: ");
			unEstudiante.setNombre(sc.next());
			System.out.println("Ingrese apellido: ");
			unEstudiante.setApellido(sc.next());
			System.out.println("Ingrese email: ");
			unEstudiante.setEmail(sc.next());
			System.out.println("Ingrese comision: ");
			unEstudiante.setComision(sc.next());
			System.out.println("Ingrese direccion: ");
			unEstudiante.setDireccion(sc.next());
		
			lista.agregarInicio(unEstudiante);
		}
		
		lista.comenzar();
		while (!lista.fin()){
			System.out.println(lista.proximo().tusDatos());
		}
	}
}
