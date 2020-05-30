package cl.jackrott.encuesta.dto;

import java.util.List;

public class FormatoEncuestaResponse {
	
	private int encuestaId;
	private List<PreguntaFormulario> preguntas;
	public FormatoEncuestaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEncuestaId() {
		return encuestaId;
	}
	public void setEncuestaId(int encuestaId) {
		this.encuestaId = encuestaId;
	}
	public List<PreguntaFormulario> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<PreguntaFormulario> preguntas) {
		this.preguntas = preguntas;
	}
	
	
}
