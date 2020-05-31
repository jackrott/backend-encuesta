package cl.jackrott.encuesta.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.jackrott.encuesta.dto.EncuestaRequest;
import cl.jackrott.encuesta.dto.FormatoEncuestaResponse;
import cl.jackrott.encuesta.dto.ResultadoRespuestaResponse;
import cl.jackrott.encuesta.services.EncuestaService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("encuestas")
public class EncuestaController {
	
	@Autowired
	private EncuestaService encuestaFormatoService;
	
	@GetMapping("/{id}/formato")
	public ResponseEntity<FormatoEncuestaResponse> findAllPaths(@PathVariable(name = "id", required = true) Integer idEncuesta) {
		
		FormatoEncuestaResponse formatoEncuesta = encuestaFormatoService.getPreguntasEncuesta(idEncuesta);
		return new ResponseEntity<FormatoEncuestaResponse>(formatoEncuesta, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public void registrarEncuesta(@RequestBody EncuestaRequest encuesta) {
		encuestaFormatoService.registrarEncuesta(encuesta);
	}
	
	
	@GetMapping("/{id}/resultado")
	public ResponseEntity<HashMap<String, List<ResultadoRespuestaResponse>>> findResultadoEncuesta(
			@PathVariable(name = "id", required = true) Integer idEncuesta) {
		
		HashMap<String, List<ResultadoRespuestaResponse>> formatoEncuesta = encuestaFormatoService.resultadoEncuesta(idEncuesta);
		return new ResponseEntity<HashMap<String, List<ResultadoRespuestaResponse>>>(formatoEncuesta, HttpStatus.OK);
	}
	

}
	