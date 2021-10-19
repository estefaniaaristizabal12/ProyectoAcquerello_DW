package com.desarrolloWeb.ProyectoAcquerello.rest;

import com.desarrolloWeb.ProyectoAcquerello.servicio.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import com.desarrolloWeb.ProyectoAcquerello.dtos.FacturaDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("factura")
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



    @PostMapping("/crear")
	public Factura createFactura(@RequestBody Factura nuevaFactura) {
		return facturaService.createFactura(nuevaFactura);
	}
    

	@DeleteMapping("/eliminarFactura")
	public String deleteFactura(@RequestParam (name = "idFactura") Long idFactura) {
		Boolean res = facturaService.deleteFactura(idFactura);
		if(res == true){
			return "Se elimino correctamente";
		}
		else{
			return "Se genero un error ";
		}
	}


	@GetMapping("/darFactura")
	public FacturaDTO getFacturaById(@RequestParam(name = "idFactura") Long idFactura){
		ModelMapper mapper = new ModelMapper();
		FacturaDTO factura = new FacturaDTO();
		Factura fact = new Factura();
		fact = facturaService.getFacturaById(idFactura);
		factura = mapper.map(fact, FacturaDTO.class);
		return factura;
	}


	@GetMapping("/listarFacturas")
	public List<FacturaDTO> getFacturas(@RequestParam(name="page") int page, 
			@RequestParam(name="size", required = false, defaultValue = "10") int size) {
	
		Page<Factura> facturas = facturaService.getFacturas(PageRequest.of(page,size));
		List<FacturaDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Factura factura : facturas) {
			result.add(mapper.map(factura, FacturaDTO.class));
		}

		return result;
		
	}
    
}
