package com.projeto.lojadegames.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotNull
	@Size (min = 3, max = 45)
	private String nomeCategoria;
	
	@NotNull
	@Size (min = 3, max = 255)
	private String descricaoCategoria;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCategoria = new java.sql.Date(System.currentTimeMillis());

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public Date getDataCategoria() {
		return dataCategoria;
	}

	public void setDataCategoria(Date dataCategoria) {
		this.dataCategoria = dataCategoria;
	}
		
}
