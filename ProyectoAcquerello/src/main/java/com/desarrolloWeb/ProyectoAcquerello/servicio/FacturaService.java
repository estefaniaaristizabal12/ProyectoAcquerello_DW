package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.FacturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class FacturaService implements IFacturaService{

    @Autowired
    private FacturaRepository repository;

    @Override
	public Factura createFactura (Factura nuevoUsuario) {
		return repository.save(nuevoUsuario);
	}

    @Override
    public Factura getFacturaById(Long idFactura){
        return repository.findById(idFactura).orElseThrow();
    }

    @Override
    public void deleteFactura (Long idFactura){
        Optional<Factura> factura = repository.findById(idFactura);
		if (factura.isPresent()) {
			repository.delete(factura.get());
		} else {
			//throw new EquipoNotFoundException(idUsuario);
		}
    }
    
}
