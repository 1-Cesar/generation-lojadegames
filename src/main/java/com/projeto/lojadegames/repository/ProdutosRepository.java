package com.projeto.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.lojadegames.model.Produtos;

/*
 * @author Edilaine Souza
 * @author Edgar Soares Marinho
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	public List<Produtos> findAllByNomeProdutoContainingIgnoreCase (String nomeProduto);
}
