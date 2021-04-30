package tp04.ejercicio1;

public class AreaEmpresa {
	private Integer retardo_mensaje;
	private String identificacion;
	
	public AreaEmpresa(Integer retardo_mensaje, String identificacion) {
		this.retardo_mensaje = retardo_mensaje;
		this.identificacion = identificacion;
	}

	public Integer getRetardo_mensaje() {
		return retardo_mensaje;
	}

	public void setRetardo_mensaje(Integer retardo_mensaje) {
		this.retardo_mensaje = retardo_mensaje;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
}
