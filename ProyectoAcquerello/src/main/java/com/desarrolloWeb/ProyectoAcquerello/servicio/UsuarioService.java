package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
	public Usuario createUsuario (Usuario nuevoUsuario) {
		return repository.save(nuevoUsuario);
	}

    @Override
    public Usuario getUsuarioById(Long idUsuario){
        return repository.findById(idUsuario).orElseThrow();
    }

    @Override
    public void deleteUsuario (Long idUsuario){
        Optional<Usuario> usuario = repository.findById(idUsuario);
		if (usuario.isPresent()) {
			repository.delete(usuario.get());
		} else {
			//throw new EquipoNotFoundException(idUsuario);
		}
    }

   


    
}
