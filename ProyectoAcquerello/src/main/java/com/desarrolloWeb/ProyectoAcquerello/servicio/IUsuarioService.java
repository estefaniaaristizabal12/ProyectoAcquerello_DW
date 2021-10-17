package com.desarrolloWeb.ProyectoAcquerello.servicio;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

public interface IUsuarioService {

    Usuario createUsuario(Usuario nuevoUsuario);

    Usuario getUsuarioById(Long idUsuario);

    void deleteUsuario (Long idUsuario);

    //Usuario actualizarUsuario(Usuario usuario, Long idUsuario);


    
}
