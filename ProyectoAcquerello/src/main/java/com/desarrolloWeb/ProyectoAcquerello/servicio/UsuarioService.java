package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.UsuarioRepository;
import java.util.Optional;

import javax.transaction.Transactional;

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
    public Iterable<Usuario> getUsuariosL(){
        return repository.findAll();
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

    @Transactional
	public Usuario updateUsuario(Usuario newUsuario) {
		Optional<Usuario> pro = repository.findById(newUsuario.get_idUsuario());
		Usuario provider = pro.get();
        provider.set_nombre(newUsuario.get_nombre());
        provider.set_apellido(newUsuario.get_apellido());
        provider.set_direccion(newUsuario.get_direccion());
        provider.set_contrasenia(newUsuario.get_contrasenia());
        provider.set_email(newUsuario.get_email());
		return repository.save(provider);
	}
  
}
