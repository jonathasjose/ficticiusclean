package br.com.ficticiusclean.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ficticiusclean.domain.model.Veiculo;
import br.com.ficticiusclean.domain.repository.VeiculoRepository;
import br.com.ficticiusclean.helper.DateUtils;
import br.com.ficticiusclean.rest.dto.VeiculoConsumoDTO;
import br.com.ficticiusclean.rest.dto.VeiculoDTO;
import br.com.ficticiusclean.rest.dto.VeiculoFiltroDTO;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	private final int DECIMAL = 2;
	
	public Veiculo salvarVeiculo(VeiculoDTO veiculoDTO) {
		
		//Validar 
		
		//Criar Veiculo
		Veiculo veiculo = getVeiculo(veiculoDTO);
		repository.salvar(veiculo);		
		return veiculo;
	}

	private Veiculo getVeiculo(VeiculoDTO veiculoDTO) {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setNome(veiculoDTO.getNome());
		veiculo.setMarca(veiculoDTO.getMarca());
		veiculo.setModelo(veiculoDTO.getModelo());
		veiculo.setDataFabricacao(veiculoDTO.getDataFabricacao());
		veiculo.setConsumoCidade(veiculoDTO.getConsumoCidade());
		veiculo.setConsumoRodovia(veiculoDTO.getConsumoRodovia());
		
		return veiculo;
	}

	public List<VeiculoConsumoDTO> buscarVeiculosPorConsumo(VeiculoFiltroDTO filtroDTO) {

		List<VeiculoConsumoDTO> veiculosPorConsumo = new ArrayList<VeiculoConsumoDTO>();
		List<Veiculo> veiculos = repository.buscarTodos();
		for (Veiculo veiculo : veiculos) {
			VeiculoConsumoDTO consumo = new VeiculoConsumoDTO();
			consumo.setNome(veiculo.getNome());
			consumo.setMarca(veiculo.getMarca());
			consumo.setModelo(veiculo.getModelo());
			consumo.setAno(DateUtils.getYearFromDate(veiculo.getDataFabricacao()));
			consumo.setQtdeCombustivelGasto(calculoQtdeCombustivelGasto(veiculo, filtroDTO));
			consumo.setValorCombustivelGasto(calculoValorCombustivelGasto(veiculo, filtroDTO));
			veiculosPorConsumo.add(consumo);
		}
		Collections.sort(veiculosPorConsumo);
		return veiculosPorConsumo;
	}
	
	private BigDecimal calculoQtdeCombustivelGasto(Veiculo veiculo, VeiculoFiltroDTO filtroDTO) {

		// Calcula o total de combustível gasto
		BigDecimal qtdeGastoCidade = calculoQtdeCombustivelGastoCidade(veiculo.getConsumoCidade(),
				filtroDTO.getTotalKmCidade());
		BigDecimal qtderGastoRodovia = calculoQtdeCombustivelGastoRodovia(veiculo.getConsumoRodovia(),
				filtroDTO.getTotalKmRodovia());

		return qtdeGastoCidade.add(qtderGastoRodovia);
	}

	private BigDecimal calculoValorCombustivelGasto(Veiculo veiculo, VeiculoFiltroDTO filtroDTO) {

		BigDecimal valorGasolina = filtroDTO.getValorGasolina() != null ? filtroDTO.getValorGasolina()
				: BigDecimal.ZERO;
		// Calcula o total de combustível gasto
		BigDecimal qtdeGastoCidade = calculoQtdeCombustivelGastoCidade(veiculo.getConsumoCidade(),
				filtroDTO.getTotalKmCidade());
		BigDecimal qtderGastoRodovia = calculoQtdeCombustivelGastoRodovia(veiculo.getConsumoRodovia(),
				filtroDTO.getTotalKmRodovia());
		// Calcula o valor total gasto com combustível
		BigDecimal valorGastoCidade = calculoValorCombustivelGastoCidade(qtdeGastoCidade, valorGasolina);
		BigDecimal valorGastoRodovia = calculoValorCombustivelGastoRodovia(qtderGastoRodovia, valorGasolina);

		return valorGastoCidade.add(valorGastoRodovia);
	}

	private BigDecimal calculoQtdeCombustivelGastoCidade(BigDecimal consumoCidade, BigDecimal totalKmCidade) {

		if (totalKmCidade != null && totalKmCidade.compareTo(BigDecimal.ZERO) == 1 && consumoCidade != null
				&& consumoCidade.compareTo(BigDecimal.ZERO) == 1) {
			return totalKmCidade.divide(consumoCidade, DECIMAL, RoundingMode.HALF_UP);
		}
		return BigDecimal.ZERO;
	}

	private BigDecimal calculoQtdeCombustivelGastoRodovia(BigDecimal consumoRodovia, BigDecimal totalKmRodovia) {

		if (totalKmRodovia != null && totalKmRodovia.compareTo(BigDecimal.ZERO) == 1 && consumoRodovia != null
				&& consumoRodovia.compareTo(BigDecimal.ZERO) == 1) {
			return totalKmRodovia.divide(consumoRodovia, DECIMAL, RoundingMode.HALF_UP);
		}
		return BigDecimal.ZERO;
	}

	private BigDecimal calculoValorCombustivelGastoCidade(BigDecimal qtdeGastoCidade, BigDecimal valorGasolina) {

		if (qtdeGastoCidade != null && qtdeGastoCidade.compareTo(BigDecimal.ZERO) == 1 && valorGasolina != null
				&& valorGasolina.compareTo(BigDecimal.ZERO) == 1) {
			return qtdeGastoCidade.multiply(valorGasolina).setScale(DECIMAL, RoundingMode.HALF_UP);
		}
		return BigDecimal.ZERO;
	}

	private BigDecimal calculoValorCombustivelGastoRodovia(BigDecimal qtdeGastoRodovia, BigDecimal valorGasolina) {
		
		if (qtdeGastoRodovia != null && qtdeGastoRodovia.compareTo(BigDecimal.ZERO) == 1 && valorGasolina != null
				&& valorGasolina.compareTo(BigDecimal.ZERO) == 1) {
			return qtdeGastoRodovia.multiply(valorGasolina).setScale(DECIMAL, RoundingMode.HALF_UP);
		}
		return BigDecimal.ZERO;
	}

}
