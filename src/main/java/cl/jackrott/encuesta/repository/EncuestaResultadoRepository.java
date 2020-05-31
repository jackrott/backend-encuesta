package cl.jackrott.encuesta.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.jackrott.encuesta.entity.ResultadoEncuesta;

@Repository
public interface EncuestaResultadoRepository extends JpaRepository<ResultadoEncuesta, Integer> {
	
	@Query("SELECT encr FROM ResultadoEncuesta encr INNER JOIN encr.encuesta enc WHERE enc.id = ?1 AND encr.email = ?2")
	List<ResultadoEncuesta> emailEncuestado(Integer idEncuesta, String email);
	
	@Query("SELECT encr FROM ResultadoEncuesta encr INNER JOIN encr.encuesta enc WHERE enc.id = ?1 ORDER BY encr.pregunta ASC")
	List<ResultadoEncuesta> resultadoEncuesta(Integer idEncuesta);

}
