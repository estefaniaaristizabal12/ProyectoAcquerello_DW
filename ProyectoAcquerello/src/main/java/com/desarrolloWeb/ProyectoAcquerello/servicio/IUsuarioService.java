package com.desarrolloWeb.ProyectoAcquerello.servicio;
import com.desarrolloWeb.ProyectoAcquerello.dtos.UsuarioDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {

    Usuario createUsuario(Usuario newUsuario);

    //Usuario getUsuarioById(String email);

    Usuario getUsuarioById(Long idPlato);

    Boolean deleteUsuario(String email);

    Page<Usuario> getUsuarios(Pageable pageable);

    Usuario updateUsuario(Usuario usuario);

    Iterable<Usuario> getUsuariosL();


    
}
