package com.desarrolloWeb.ProyectoAcquerello.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

public interface UsuarioRepository extends  JpaRepository<Usuario, Long> {
   // List<Usuario> findByLastname (String apellido);
    
}

