package com.desarrolloWeb.ProyectoAcquerello.repositorio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

@Repository
public interface UsuarioRepository extends  PagingAndSortingRepository<Usuario, Long> {
   
}

