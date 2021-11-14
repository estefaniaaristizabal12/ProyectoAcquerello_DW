package com.desarrolloWeb.ProyectoAcquerello.repositorio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

@Repository
public interface UsuarioRepository extends  PagingAndSortingRepository<Usuario, Long> {
  /*
   // ---------- Actualizar informacion del usuario -------------------

   @Query("update Usuario u set u.nombre = ?1 where u.idUsuario = ?2")
   void updateNombreUsuario(String nombre, Long idUsuario);

   @Query("update Usuario u set u.apellido = ?1 where u.idUsuario = ?2")
   void updateApellidoUsuario(String apellido, Long idUsuario);

   @Query("update Usuario u set u.email = ?1 where u.idUsuario = ?2")
   void updateEmailUsuario(String email, Long idUsuario);


   // ------------- Eliminar Usuario ------------------------

   @Query("delete from Usuario where idUsuario = ?1")
   void deleteUsuarioById(Long idUsuario);

   @Query("delete from Usuario where email = ?1")
   void deleteUsuarioByEmail(String email);

   // ------------- Buscar Usuario ------------------------

   List<Usuario> findByEmail (String email);

   Usuario findByIdUsuario (Long idUsuario); */
   
}

