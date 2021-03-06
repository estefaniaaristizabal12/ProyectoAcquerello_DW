package com.desarrolloWeb.ProyectoAcquerello.repositorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

@Repository
public interface FacturaRepository extends  CrudRepository<Factura, Long>  {
    List<Factura> findByUsuariof(Usuario usuariof);   

    @Query(nativeQuery = true, value = "SELECT f.* FROM Factura f JOIN Usuario u ON f.usuario_Id = u._id_Usuario WHERE u._id_Usuario = ?1")
    List<Factura> findByUsuarioFa( Long idUsuario);

    @Query(nativeQuery = true, value = "SELECT f.* FROM Factura f JOIN Plato p ON f.platoId = p._idPlato WHERE p._idPlato = ?1")
    List<Factura> findByPlatoFa( Long idPlato);
}