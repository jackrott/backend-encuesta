package cl.jackrott.encuesta.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.jackrott.encuesta.dto.EncuestaRequest;
import cl.jackrott.encuesta.dto.FormatoEncuestaResponse;
import cl.jackrott.encuesta.dto.PreguntaFormulario;
import cl.jackrott.encuesta.dto.RespuestaUsuario;
import cl.jackrott.encuesta.dto.ResultadoRespuestaResponse;
import cl.jackrott.encuesta.entity.EncuestaFormato;
import cl.jackrott.encuesta.entity.Respuesta;
import cl.jackrott.encuesta.entity.ResultadoEncuesta;
import cl.jackrott.encuesta.exception.CustomEncuestaException;
import cl.jackrott.encuesta.exception.CustomNotFoundException;
import cl.jackrott.encuesta.repository.EncuestaFormatoRepository;
import cl.jackrott.encuesta.repository.EncuestaRepository;
import cl.jackrott.encuesta.repository.EncuestaResultadoRepository;
import cl.jackrott.encuesta.repository.PreguntaRepository;
import cl.jackrott.encuesta.repository.RespuestaRepository;

@Component
public class EncuestaService {
	
	@Autowired 	
	private EncuestaFormatoRepository repository;
	
	@Autowired 
	private EncuestaResultadoRepository encuestaResultadoRepository;
	
	@Autowired 
	private EncuestaRepository encuestaRepository;
	
	@Autowired 
	private PreguntaRepository preguntaRepository;
	
	@Autowired 
	private RespuestaRepository respuestaRepository;
	
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
	
	
	public void registrarEncuesta(EncuestaRequest encuesta) {
		
		List<EncuestaFormato> preguntas = repository.findPreguntas(encuesta.getIdEncuesta(), 1); //Activas
		
		if(preguntas.isEmpty()) {
			throw new CustomNotFoundException("Encuesta no existe");
		}
		
		List<ResultadoEncuesta> encuestado = encuestaResultadoRepository
				.emailEncuestado(encuesta.getIdEncuesta(), encuesta.getEmail());
		
		if(!encuestado.isEmpty()) {
			throw new CustomEncuestaException("El mail: " + encuesta.getEmail() + " ya ha respondido esta encuesta anteriormente");
		}
		
		for(RespuestaUsuario resp: encuesta.getRespuestas()) {
			ResultadoEncuesta encuestaEntity = new ResultadoEncuesta();
			encuestaEntity.setPregunta(preguntaRepository.getOne(resp.getIdPregunta()));
			encuestaEntity.setEncuesta(encuestaRepository.getOne(encuesta.getIdEncuesta()));
			
			encuestaEntity.setEmail(encuesta.getEmail());
			encuestaEntity.setRespuesta(respuestaRepository.getOne(resp.getValorRespuesta()));
			encuestaResultadoRepository.save(encuestaEntity);
		}
    }
	
	
	public HashMap<String, List<ResultadoRespuestaResponse>> resultadoEncuesta(Integer encuestaId) {
		
		List<ResultadoEncuesta> resultadoEncuesta = encuestaResultadoRepository.resultadoEncuesta(encuestaId); //Activas
		HashMap<String, List<ResultadoRespuestaResponse>> mapRes = new HashMap<String, List<ResultadoRespuestaResponse>>();
		
		if(resultadoEncuesta.isEmpty()) {
			return mapRes;
		}
		
		for(ResultadoEncuesta resultado: resultadoEncuesta) {
			String keyHash = resultado.getPregunta().getDescripcion();
			
			ResultadoRespuestaResponse rrp = new ResultadoRespuestaResponse();
			rrp.setEmail(resultado.getEmail());
			rrp.setDescripcionRespuesta(resultado.getRespuesta().getDescripcion());
			
			if(mapRes.containsKey(keyHash)) {
				mapRes.get(keyHash).add(rrp);
			} else {
				List<ResultadoRespuestaResponse> listResultadoRespuesta = new ArrayList<>();
				listResultadoRespuesta.add(rrp);
				mapRes.put(keyHash, listResultadoRespuesta);
			}
		}
		
		
        return mapRes;
    }
	
}
