package br.com.ficticiusclean.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;

	@Column(length = 100)
	private String nome;

	@Column(length = 100)
	private String marca;

	@Column(length = 100)
	private String modelo;

	@Column(name = "DT_FABRICACAO")
	private Date dataFabricacao;

	@Column(name = "VL_CONSUMO_CIDADE", nullable = false)
	private BigDecimal consumoCidade;

	@Column(name = "VL_CONSUMO_RODOVIA", nullable = false)
	private BigDecimal consumoRodovia;

	public Veiculo() {

	}

	public Veiculo(String nome, String marca, String modelo, Date dataFabricacao, BigDecimal consumoCidade,
			BigDecimal consumoRodovia) {

		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
		this.consumoCidade = consumoCidade;
		this.consumoRodovia = consumoRodovia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
