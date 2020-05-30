package cl.jackrott.encuesta.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enc_resultado")
public class ResultadoEncuesta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@JoinColumn(name = "encuesta_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Encuesta encuesta;
	
	@JoinColumn(name = "enc_pregunta_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Pregunta pregunta;
	
	@JoinColumn(name = "enc_respuesta_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Respuesta respuesta;

	public ResultadoEncuesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "ResultadoEncuesta [id=" + id + ", usuario=" + usuario + ", encuesta=" + encuesta + ", pregunta="
				+ pregunta + ", respuesta=" + respuesta + "]";
	}
}
