package Ejercicio3;

public abstract class Persona {
	
	//variables de instancia
	private String nombre;
	private String apellido;
	private String email;
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String tusDatos(){
		String aux = " Nombre: "+this.getNombre()+" Apellido: "+this.getApellido()+" Email: "+this.getEmail();
		return aux;
	}

}
