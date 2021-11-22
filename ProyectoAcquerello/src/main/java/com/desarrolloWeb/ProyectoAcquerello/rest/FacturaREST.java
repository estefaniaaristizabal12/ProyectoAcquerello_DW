package com.desarrolloWeb.ProyectoAcquerello.rest;

import com.desarrolloWeb.ProyectoAcquerello.servicio.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import com.desarrolloWeb.ProyectoAcquerello.dtos.FacturaDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("factura")
public class FacturaREST {

    @Autowired
	private IFacturaService facturaService;


	// - - - - - - - -  C   R   U  D  - - - - - - - - 

    @PostMapping("/crear")
	public FacturaDTO createFactura(@RequestBody FacturaDTO nuevaFactura) {
		Factura factura = new Factura();
		ModelMapper mapper = new ModelMapper();
		factura = mapper.map(nuevaFactura, Factura.class);
		factura = facturaService.createFactura(factura);
		nuevaFactura = mapper.map(factura, FacturaDTO.class);
		return nuevaFactura;
	}

	@GetMapping("/listaFacturas")
	public List<FacturaDTO> getFacturas() {
		Iterable<Factura> facturas = facturaService.getFacturaLista();
		List<FacturaDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		for (Factura factura : facturas) {
			result.add(mapper.map(factura, FacturaDTO.class));
		}
		return result;
	}

	@GetMapping("/listaFacturasXUsuario/{idFactura}")
	public List<FacturaDTO> getFacturasXUsuario(@PathVariable Long idFactura) {
		Factura factura = facturaService.getFacturaById(idFactura);
		ModelMapper mapper = new ModelMapper();
		Iterable<Factura> facturas = facturaService.getFacturaListaXUsuario(factura);
		List<FacturaDTO> result = new ArrayList<>();
		for (Factura fact : facturas) {
			result.add(mapper.map(fact, FacturaDTO.class));
		}
		return result;
	}



	@PutMapping("/actualizarFactura/{idFactura}")
	public FacturaDTO actualizarPlato(@RequestBody FacturaDTO newFactura, @PathVariable Long idFactura){
		Factura factura = new Factura();
		ModelMapper mapper = new ModelMapper();
		factura = mapper.map(newFactura, Factura.class);
		factura = facturaService.updateFactura(factura);
		newFactura = mapper.map(factura, FacturaDTO.class);
		return newFactura;
	}



	@DeleteMapping("/eliminar/{idFactura}")
	public Boolean deletePlato(@PathVariable Long idFactura) {
		facturaService.deleteFactura(idFactura);
		return true;
	}
  
}
