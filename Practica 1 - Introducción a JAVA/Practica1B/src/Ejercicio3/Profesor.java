package Ejercicio3;

public class Profesor extends Persona{
	//variables de instancia
	private String catedra;
	private String facultad;
	
	//getters y setters
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos(){
		String aux = super.tusDatos()+" Facultad: "+this.getFacultad()+" Catedra: "+this.getCatedra();
		return aux;
	}
	
	
}
