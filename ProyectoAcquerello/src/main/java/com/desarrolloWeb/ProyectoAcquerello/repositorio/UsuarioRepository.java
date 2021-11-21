package com.desarrolloWeb.ProyectoAcquerello.repositorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

@Repository
public interface UsuarioRepository extends  CrudRepository<Usuario, Long> {

    @Query(nativeQuery = true, value = "SELECT u FROM Usuario u WHERE u._email = ?1")
    Optional<Usuario> findByEmail(String email);
}

