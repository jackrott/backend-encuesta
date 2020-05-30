package cl.jackrott.encuesta.dto;

import java.util.List;

import cl.jackrott.encuesta.entity.Respuesta;

public class PreguntaFormulario {

	private int preguntaId;
	private String descripcionPregunta;
	private List<Respuesta> respuestas;
	public int getPreguntaId() {
		return preguntaId;
	}
	public void setPreguntaId(int preguntaId) {
		this.preguntaId = preguntaId;
	}
	public String getDescripcionPregunta() {
		return descripcionPregunta;
	}
	public void setDescripcionPregunta(String descripcionPregunta) {
		this.descripcionPregunta = descripcionPregunta;
	}
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	@Override
	public String toString() {
		return "PreguntaFormulario [preguntaId=" + preguntaId + ", descripcionPregunta=" + descripcionPregunta
				+ ", respuestas=" + respuestas + "]";
	}

}
