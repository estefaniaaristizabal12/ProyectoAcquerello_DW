package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.FacturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /*
    @Override
    public Factura getFacturaById(Long idFactura){
        return repository.findById(idFactura).orElseThrow();
    }
    */


    @Override
    public Boolean deleteFactura (Long idFactura){
        Boolean delet = false;
        Optional<Factura> factura = repository.findById(idFactura);
		if (factura.isPresent()) {
			repository.delete(factura.get());
            delet = true;
		} else {
            System.out.println("ERRORRR");
			//throw new EquipoNotFoundException(idUsuario);
		}

        return delet;
    }

    @Override
    public Factura getFacturaById(Long idFactura){
        Optional<Factura> factura = repository.findById(idFactura);
        if (factura.isPresent()) {
			return factura.get();
		}
        else{
            System.out.println("ERRORRR");
            return factura.get();
        }
    }

    @Override
	public Page<Factura> getFacturas(Pageable pageable) {
		return repository.findAll(pageable);
	}

  
    
}
