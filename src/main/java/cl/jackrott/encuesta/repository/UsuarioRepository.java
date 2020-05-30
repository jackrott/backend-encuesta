package cl.jackrott.encuesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.jackrott.encuesta.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
