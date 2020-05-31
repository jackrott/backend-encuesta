package cl.jackrott.encuesta.dto;

public class RespuestaUsuario {
	
	private Integer idPregunta;
	private Integer valorRespuesta;
	public RespuestaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}
	public Integer getValorRespuesta() {
		return valorRespuesta;
	}
	public void setValorRespuesta(Integer valorRespuesta) {
		this.valorRespuesta = valorRespuesta;
	}
	@Override
	public String toString() {
		return "RespuestaUsuario [idPregunta=" + idPregunta + ", valorRespuesta=" + valorRespuesta + "]";
	}
	
}
