package cl.jackrott.encuesta.dto;

import java.util.List;

public class EncuestaRequest {
	
	private Integer idEncuesta;
	private String email;
	private List<RespuestaUsuario> respuestas;
	public EncuestaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdEncuesta() {
		return idEncuesta;
	}
	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<RespuestaUsuario> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<RespuestaUsuario> respuestas) {
		this.respuestas = respuestas;
	}
	@Override
	public String toString() {
		return "EncuestaRequest [idEncuesta=" + idEncuesta + ", email=" + email + ", respuestas=" + respuestas + "]";
	}

	
	
}
