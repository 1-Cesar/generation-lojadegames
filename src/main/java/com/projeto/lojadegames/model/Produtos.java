package com.projeto.lojadegames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produtos")

public class Produtos {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotNull
	@Size (min = 3, max = 45)
	private String nomeProduto;
	
	@NotNull
	@Size()
	private Double valorProduto;
	
	@NotNull
	@Size (min = 3, max = 45)
	private String marcaProduto;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;


	public Long getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public Double getValorProduto() {
		return valorProduto;
	}


	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}


	public String getMarcaProduto() {
		return marcaProduto;
	}


	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
