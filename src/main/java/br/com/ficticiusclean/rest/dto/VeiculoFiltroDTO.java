package br.com.ficticiusclean.rest.dto;

import java.math.BigDecimal;

public class VeiculoFiltroDTO {

	private BigDecimal valorGasolina;
	private BigDecimal totalKmCidade;
	private BigDecimal totalKmRodovia;

	public VeiculoFiltroDTO(BigDecimal valorGasolina, BigDecimal totalKmCidade, BigDecimal totalKmRodovia) {
		
		this.valorGasolina = valorGasolina;
		this.totalKmCidade = totalKmCidade;
		this.totalKmRodovia = totalKmRodovia;
	}

	public BigDecimal getValorGasolina() {
		return valorGasolina;
	}

	public void setValorGasolina(BigDecimal valorGasolina) {
		this.valorGasolina = valorGasolina;
	}

	public BigDecimal getTotalKmCidade() {
		return totalKmCidade;
	}

	public void setTotalKmCidade(BigDecimal totalKmCidade) {
		this.totalKmCidade = totalKmCidade;
	}

	public BigDecimal getTotalKmRodovia() {
		return totalKmRodovia;
	}

	public void setTotalKmRodovia(BigDecimal totalKmRodovia) {
		this.totalKmRodovia = totalKmRodovia;
	}

}
