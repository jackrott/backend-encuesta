package cl.jackrott.encuesta.services;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import cl.jackrott.encuesta.entity.Encuesta;
import cl.jackrott.encuesta.entity.Pregunta;
import cl.jackrott.encuesta.entity.Respuesta;
import cl.jackrott.encuesta.entity.ResultadoEncuesta;
import cl.jackrott.encuesta.repository.EncuestaResultadoRepository;

@SpringBootTest
public class EncuestaServiceTest {
	
	
	@Mock
	private EncuestaResultadoRepository encuestaResultadoRepository;

	@InjectMocks
	private EncuestaService service;
	
	@Test
	void findResultadoEncuesta_OK() {
		
		Integer idEncuesta = 1;
		String email = "email@email.com";
		List<ResultadoEncuesta> resultados = new ArrayList<ResultadoEncuesta>();
		ResultadoEncuesta resultado = new ResultadoEncuesta();
		resultado.setEmail(email);
		Pregunta pregunta = new Pregunta();
		pregunta.setDescripcion("Pregunta 1");
		pregunta.setId(1);
		resultado.setPregunta(pregunta);
		
		Encuesta encuesta = new Encuesta();
		encuesta.setDescripcion("Descripcion encuesta");
		encuesta.setId(1);
		resultado.setEncuesta(encuesta);
		
		Respuesta respuesta = new Respuesta();
		respuesta.setDescripcion("respuesta 1");
		respuesta.setId(1);
		respuesta.setPregunta(pregunta);
		resultado.setRespuesta(respuesta);

		Mockito.doReturn(resultados).when(encuestaResultadoRepository).emailEncuestado(Mockito.any(), Mockito.any()); 
		service.resultadoEncuesta(idEncuesta);
	}
}
