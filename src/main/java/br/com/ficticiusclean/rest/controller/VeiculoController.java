package br.com.ficticiusclean.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ficticiusclean.domain.model.Veiculo;
import br.com.ficticiusclean.rest.dto.VeiculoConsumoDTO;
import br.com.ficticiusclean.rest.dto.VeiculoDTO;
import br.com.ficticiusclean.rest.dto.VeiculoFiltroDTO;
import br.com.ficticiusclean.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo salvarVeiculo(@Valid @RequestBody VeiculoDTO veiculo) {
		return service.salvarVeiculo(veiculo);
	}

	@GetMapping("/vlgasolina/{vlgasolina}")
	public List<VeiculoConsumoDTO> buscarVeiculosPorConsumo(@PathVariable BigDecimal vlgasolina,
			@RequestParam(required = false) BigDecimal kmcidade, @RequestParam(required = false) BigDecimal kmrodovia) {
		
		VeiculoFiltroDTO filtro = new VeiculoFiltroDTO(vlgasolina, kmcidade, kmrodovia);
		return service.buscarVeiculosPorConsumo(filtro);
	}
}
