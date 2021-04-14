package Ejercicio3;

public class Test {
	public static void main (String [] args){
		
		Estudiante[] vectorEstudiantes = new Estudiante[2];
		Profesor[] vectorProfesores = new Profesor[3];
		
		for (int i = 0; i < 2; i++){
			vectorEstudiantes[i] = new Estudiante();
		}
		
		for (int i = 0; i < 3; i++){
			vectorProfesores[i] = new Profesor();
		}
		
		//Estudiantes
		vectorEstudiantes[0].setNombre("Juan");
		vectorEstudiantes[0].setApellido("Perez");
		vectorEstudiantes[0].setEmail("juanpe@gmail.com");
		vectorEstudiantes[0].setDireccion("55 111");
		vectorEstudiantes[0].setComision("1A");
		
		vectorEstudiantes[1].setNombre("Maria");
		vectorEstudiantes[1].setApellido("Rodriguez");
		vectorEstudiantes[1].setEmail("mariaro@gmail.com");
		vectorEstudiantes[1].setDireccion("68 235");
		vectorEstudiantes[1].setComision("1B");
		
		//Profesores
		vectorProfesores[0].setNombre("Jose");
		vectorProfesores[0].setApellido("Martinez");
		vectorProfesores[0].setEmail("josemart@gmail.com");
		vectorProfesores[0].setFacultad("Informatica");
		vectorProfesores[0].setCatedra("Algoritmos y Estructuras de Datos");
		
		vectorProfesores[1].setNombre("Marta");
		vectorProfesores[1].setApellido("Fernandez");
		vectorProfesores[1].setEmail("mfernandez@gmail.com");
		vectorProfesores[1].setFacultad("Ingenieria");
		vectorProfesores[1].setCatedra("Programacion 1");
	
		vectorProfesores[2].setNombre("Charly");
		vectorProfesores[2].setApellido("Garcia");
		vectorProfesores[2].setEmail("cg@gmail.com");
		vectorProfesores[2].setFacultad("Ingenieria");
		vectorProfesores[2].setCatedra("Programacion 1");
	
		for (int i = 0; i < 2; i++){
			System.out.println(vectorEstudiantes[i].tusDatos());
		}
	
		for (int i = 0; i < 3; i++){
			System.out.println(vectorProfesores[i].tusDatos());
		}
	}

}
