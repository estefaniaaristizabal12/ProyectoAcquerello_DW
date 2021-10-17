package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
	public Usuario createUsuario (Usuario nuevoUsuario) {
		return repository.save(nuevoUsuario);
	}

    @Override
	public Page<Usuario> getUsuarios(Pageable pageable) {
		return repository.findAll(pageable);
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