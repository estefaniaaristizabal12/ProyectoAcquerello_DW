package com.desarrolloWeb.ProyectoAcquerello.servicio;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {

    Usuario createUsuario(Usuario nuevoUsuario);

    Usuario getUsuarioById(Long idUsuario);

    Boolean deleteUsuario (Long idUsuario);

    Page<Usuario> getUsuarios(Pageable pageable);

    //Usuario actualizarUsuario(Usuario usuario, Long idUsuario);


    
}
