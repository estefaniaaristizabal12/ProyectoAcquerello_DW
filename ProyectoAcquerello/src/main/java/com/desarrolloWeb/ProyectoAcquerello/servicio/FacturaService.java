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
    public Factura createFactura(Factura newFactura){
        return repository.save(newFactura);
    }

    @Override
    public Factura getFacturaById(Long idFactura){
        Optional<Factura> factura = repository.findById(idFactura);
        if (factura.isPresent()) {
			return factura.get();
		}
        else{
            System.out.println("ERROR");
            return factura.get();
        }
    }

    @Override
    public Iterable<Factura> getFacturaLista(){
        return repository.findAll();
    }

    //OJO ACA
	@Override
	public Iterable<Factura> getFacturaByIdUsuario(Long idUsuario){
		return repository.findByUsuarioFa(idUsuario);
	}

    @Override
    public Iterable<Factura> getFacturaListaXUsuario(Factura factura){
        return repository.findByUsuariof(factura.getUsuariof());
    }

    @Override
    public Factura updateFactura(Factura newFactura){
        Factura provider = getFacturaById(newFactura.getIdFactura());
		provider.setCantidad(newFactura.getCantidad());
        provider.setFecha(newFactura.getFecha());
        provider.setFoto(newFactura.getFoto());
        provider.setPlatof(newFactura.getPlatof());
        provider.setTotal(newFactura.getTotal());
        provider.setUsuariof(newFactura.getUsuariof());
		repository.save(provider);
		return provider;

    }

    @Override
    public void deleteFactura(Long idFactura){
        Optional<Factura> factura = repository.findById(idFactura);
		if (factura.isPresent()) {
			repository.delete(factura.get());
		} else {
			System.out.println("ERROR");
		} 

    }
    
}
