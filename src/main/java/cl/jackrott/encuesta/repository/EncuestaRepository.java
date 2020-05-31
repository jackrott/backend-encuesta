package cl.jackrott.encuesta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.jackrott.encuesta.entity.Encuesta;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, Integer> {

}
