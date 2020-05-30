package cl.jackrott.encuesta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.jackrott.encuesta.entity.Usuario;
import cl.jackrott.encuesta.repository.UsuarioRepository;

@Component
public class UsuarioService {
	
	@Autowired 
	private UsuarioRepository repository;
	
	public List<Usuario> getUsuarios() {
        return (List<Usuario>) repository.findAll();
    }

}
