package com.desarrolloWeb.ProyectoAcquerello.servicio;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;


public interface IUsuarioService {

    Usuario createUsuario(Usuario newUsuario);

    Usuario getUsuarioById(Long idUsuario);

    Iterable<Usuario> getUsuariosLista();

    Usuario updateUsuario(Usuario usuario);

    Boolean deleteUsuario(String email);
   
    
}
