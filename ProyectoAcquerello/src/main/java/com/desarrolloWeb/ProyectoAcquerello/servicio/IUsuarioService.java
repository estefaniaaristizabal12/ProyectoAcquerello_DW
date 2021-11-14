package com.desarrolloWeb.ProyectoAcquerello.servicio;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {

    Usuario createUsuario(Usuario nuevoUsuario);

    Usuario getUsuarioById(String email);

    Boolean deleteUsuario(String email);

    Page<Usuario> getUsuarios(Pageable pageable);

    Usuario updateUsuario(Usuario usuario);

    Iterable<Usuario> getUsuariosL();


    
}
