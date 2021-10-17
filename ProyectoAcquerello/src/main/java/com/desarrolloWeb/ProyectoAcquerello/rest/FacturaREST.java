package com.desarrolloWeb.ProyectoAcquerello.rest;

import com.desarrolloWeb.ProyectoAcquerello.servicio.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import com.desarrolloWeb.ProyectoAcquerello.dtos.FacturaDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FacturaREST {

    @Autowired
	private IFacturaService facturaService;

    private List<FacturaDTO> convertirDTOs(Page<Factura> facturas) {
		List<FacturaDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Factura factura : facturas) {
			result.add(mapper.map(factura, FacturaDTO.class));
		}
		
		return result;
	}

    @DeleteMapping("/facturas/eliminar/{id}")
	public void deleteFactura(@PathVariable Long idFactura) {
		facturaService.deleteFactura(idFactura);
	}

    @PostMapping("/facturas/crear")
	public Factura createFactura(@RequestBody Factura nuevaFactura) {
		return facturaService.createFactura(nuevaFactura);
	}
    
    
}
