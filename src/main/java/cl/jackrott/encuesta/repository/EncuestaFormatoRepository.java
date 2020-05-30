package cl.jackrott.encuesta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.jackrott.encuesta.entity.EncuestaFormato;

@Repository
public interface EncuestaFormatoRepository extends JpaRepository<EncuestaFormato, Integer> {
	
	@Query("SELECT ef FROM EncuestaFormato ef INNER JOIN ef.encuesta enc INNER JOIN ef.pregunta p WHERE enc.id = ?1 AND ef.estado.id = ?2")
	List<EncuestaFormato> findPreguntas(Integer idEncuesta, Integer active);

}
