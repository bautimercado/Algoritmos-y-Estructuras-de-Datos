package Ejercicio3;

public class Estudiante extends Persona {
	//variables de instancia
	private String direccion;
	private String comision;
	
	//getters y setters
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	
	public String tusDatos(){
		String aux = super.tusDatos() + " Comision: "+this.getComision()+ " Direccion: "+this.getDireccion();
		return aux;
	}
	
}
