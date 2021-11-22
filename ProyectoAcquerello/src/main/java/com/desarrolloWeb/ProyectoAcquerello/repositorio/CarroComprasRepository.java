package com.desarrolloWeb.ProyectoAcquerello.repositorio;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CarroComprasRepository extends JpaRepository <CarroCompras, Long>{
    
    List<CarroCompras> findByUsuarioc (Usuario usuario); 

    @Query(nativeQuery = true, value = "SELECT c.* FROM Carro_Compras c JOIN Usuario u ON c.usuarioid = u._id_Usuario WHERE u._id_Usuario = ?1")
    List<CarroCompras> findByUsuarioCC( Long idUsuario);

}
