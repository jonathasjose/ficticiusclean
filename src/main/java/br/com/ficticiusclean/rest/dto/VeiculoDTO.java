package br.com.ficticiusclean.rest.dto;

import java.math.BigDecimal;
import java.sql.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VeiculoDTO {
	
	@NotEmpty(message = "Nome do veículo é obrigatório.")
	private String nome;
	private String marca;
	private String modelo;
	private Date dataFabricacao;
	@NotNull(message = "Valor do consumo de gasolina (Km/L) na cidade é obrigatório.")
	private BigDecimal consumoCidade;
	@NotNull(message = "Valor do consumo de gasolina (Km/L) em rodovia é obrigatório.")
	private BigDecimal consumoRodovia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public BigDecimal getConsumoCidade() {
		return consumoCidade;
	}

	public void setConsumoCidade(BigDecimal consumoCidade) {
		this.consumoCidade = consumoCidade;
	}

	public BigDecimal getConsumoRodovia() {
		return consumoRodovia;
	}

	public void setConsumoRodovia(BigDecimal consumoRodovia) {
		this.consumoRodovia = consumoRodovia;
	}

}
