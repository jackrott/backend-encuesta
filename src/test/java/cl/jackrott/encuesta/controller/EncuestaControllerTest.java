package cl.jackrott.encuesta.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import cl.jackrott.encuesta.dto.ResultadoRespuestaResponse;
import cl.jackrott.encuesta.services.EncuestaService;

@SpringBootTest
public class EncuestaControllerTest {
	
	@Mock
	private EncuestaController encuestaController;
	
	@Mock
	private EncuestaService encuestaService;
	

	@Test
	void findResultadoEncuesta_ok() {
		
		Integer idEncuesta = 1;
		HashMap<String, List<ResultadoRespuestaResponse>> value = new HashMap<String, List<ResultadoRespuestaResponse>>();
		List<ResultadoRespuestaResponse> ressp = new ArrayList<>();
		ResultadoRespuestaResponse resultadoRespuestaResponse = new ResultadoRespuestaResponse();
		resultadoRespuestaResponse.setEmail("email@email.cl");
		resultadoRespuestaResponse.setDescripcionRespuesta("Descripcion");
		ressp.add(resultadoRespuestaResponse);
		value.put("key1", ressp);
		Mockito.when(encuestaService.resultadoEncuesta(idEncuesta))
		.thenReturn(value);
		
		
		encuestaController.findResultadoEncuesta(idEncuesta);
		
	}
}