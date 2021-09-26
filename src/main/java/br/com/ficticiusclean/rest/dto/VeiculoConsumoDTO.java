package br.com.ficticiusclean.rest.dto;

import java.math.BigDecimal;

public class VeiculoConsumoDTO implements Comparable<VeiculoConsumoDTO> {

	private String nome;
	private String marca;
	private String modelo;
	private Integer ano;
	private BigDecimal qtdeCombustivelGasto;
	private BigDecimal valorCombustivelGasto;

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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public BigDecimal getQtdeCombustivelGasto() {
		return qtdeCombustivelGasto;
	}

	public void setQtdeCombustivelGasto(BigDecimal qtdeCombustivelGasto) {
		this.qtdeCombustivelGasto = qtdeCombustivelGasto;
	}

	public BigDecimal getValorCombustivelGasto() {
		return valorCombustivelGasto;
	}

	public void setValorCombustivelGasto(BigDecimal valorCombustivelGasto) {
		this.valorCombustivelGasto = valorCombustivelGasto;
	}

	@Override
	public String toString() {
		
		return "nome: " + nome 
				+ " | marca: " + marca 
				+ " | modelo: " + modelo 
				+ " | ano: " + ano 
				+ " | qtdeCombustivelGasto: " + qtdeCombustivelGasto 
				+ " | valorCombustivelGasto: " + valorCombustivelGasto;
	}

	@Override
	public int compareTo(VeiculoConsumoDTO o) {
		return valorCombustivelGasto.compareTo(o.getValorCombustivelGasto());
	}
}
