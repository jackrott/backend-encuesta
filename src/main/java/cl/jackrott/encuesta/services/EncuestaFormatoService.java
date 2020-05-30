package cl.jackrott.encuesta.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.jackrott.encuesta.dto.FormatoEncuestaResponse;
import cl.jackrott.encuesta.dto.PreguntaFormulario;
import cl.jackrott.encuesta.entity.EncuestaFormato;
import cl.jackrott.encuesta.entity.Pregunta;
import cl.jackrott.encuesta.entity.Respuesta;
import cl.jackrott.encuesta.exception.CustomNotFoundException;
import cl.jackrott.encuesta.repository.EncuestaFormatoRepository;

@Component
public class EncuestaFormatoService {
	
	@Autowired 
	private EncuestaFormatoRepository repository;
	
	public FormatoEncuestaResponse getPreguntasEncuesta(Integer encuestaId) {
		
		List<EncuestaFormato> preguntas = repository.findPreguntas(encuestaId, 1); //Activas
		
		if(preguntas.isEmpty()) {
			throw new CustomNotFoundException("Encuesta no existe");
		}
		
		FormatoEncuestaResponse encuestaFormatoResponse = new FormatoEncuestaResponse();
		for(EncuestaFormato encuestaFormato: preguntas) {
			encuestaFormatoResponse.setEncuestaId(encuestaFormato.getEncuesta().getId());
			List<PreguntaFormulario> prg = new ArrayList<>();
			PreguntaFormulario preguntaFormulario = new PreguntaFormulario();
			preguntaFormulario.setPreguntaId(encuestaFormato.getPregunta().getId());
			preguntaFormulario.setDescripcionPregunta(encuestaFormato.getPregunta().getDescripcion());
			List<Respuesta> resps = new ArrayList<>();
			resps.addAll(encuestaFormato.getPregunta().getRespuestas());
			preguntaFormulario.setRespuestas(resps);
			prg.add(preguntaFormulario);
			encuestaFormatoResponse.setPreguntas(prg);
		}
		
        return encuestaFormatoResponse;
    }
}
