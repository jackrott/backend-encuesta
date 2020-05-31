package cl.jackrott.encuesta.dto;

public class ResultadoRespuestaResponse {
	
	private String email;
	private String descripcionRespuesta;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}
	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
	@Override
	public String toString() {
		return "ResultadoRespuestaResponse [email=" + email + ", descripcionRespuesta=" + descripcionRespuesta + "]";
	}
}
