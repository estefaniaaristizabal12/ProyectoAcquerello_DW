package com.desarrolloWeb.ProyectoAcquerello.repositorio;
//import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.jpa.repository.Query;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

@Repository
public interface UsuarioRepository extends  CrudRepository<Usuario, Long> {
   // List<Usuario> findByLastname (String apellido);
    
}

