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
    public Usuario getUsuarioById(String email){
        long id = 0;
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isPresent()) {
			return usuario.get();
		}
        else{
            System.out.println("ERRORRR");
            return usuario.get();
        }
    }

    @Override
    public Boolean deleteUsuario (String emai){
        Boolean delet = false;
        long id = 0;
        Optional<Usuario> usuario = repository.findById(id);
		if (usuario.isPresent()) {
			repository.delete(usuario.get());
            delet = true;
		} else {
            System.out.println("ERRORRR");
			//throw new EquipoNotFoundException(idUsuario);
		}

        return delet;
    }
  
}
