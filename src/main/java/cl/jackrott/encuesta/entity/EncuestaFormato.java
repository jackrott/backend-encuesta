package cl.jackrott.encuesta.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "encuesta_formato", uniqueConstraints={@UniqueConstraint(columnNames={"encuesta_id", "pregunta_id"})})
public class EncuestaFormato {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encuesta_id", nullable = false)
	private Encuesta encuesta;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id", nullable = false)
	private Pregunta pregunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", nullable = false)
	private Estado estado;
	
	public EncuestaFormato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EncuestaPregunta [id=" + id + ", encuesta=" + encuesta + ", pregunta=" + pregunta + ", estado=" + estado
				+ "]";
	}
}
