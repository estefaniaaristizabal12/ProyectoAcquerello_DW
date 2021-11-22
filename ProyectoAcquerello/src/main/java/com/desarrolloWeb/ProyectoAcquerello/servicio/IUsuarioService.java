package com.desarrolloWeb.ProyectoAcquerello.servicio;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;


public interface IUsuarioService {

    Usuario createUsuario(Usuario newUsuario);

    Usuario getUsuarioById(Long idUsuario);

    Usuario getUsuarioByEmail(String emailUsuario);

    Long getIdXEmail(String emailUsuario);

    Iterable<Usuario> getUsuariosLista();

    Usuario updateUsuario(Usuario usuario, Long idUsuario);

    Boolean deleteUsuario(String email);
   
    
}
