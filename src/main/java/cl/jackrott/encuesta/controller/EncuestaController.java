package cl.jackrott.encuesta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.jackrott.encuesta.dto.FormatoEncuestaResponse;
import cl.jackrott.encuesta.services.EncuestaFormatoService;

@RestController
@RequestMapping("encuestas")
public class EncuestaController {
	
	@Autowired
	private EncuestaFormatoService encuestaFormatoService;
	
	@GetMapping("/{id}/formato")
	public ResponseEntity<FormatoEncuestaResponse> findAllPaths(@PathVariable(name = "id", required = true) Integer idEncuesta) {
		
		FormatoEncuestaResponse formatoEncuesta = encuestaFormatoService.getPreguntasEncuesta(idEncuesta);
		return new ResponseEntity<FormatoEncuestaResponse>(formatoEncuesta, HttpStatus.OK);
	}

}
