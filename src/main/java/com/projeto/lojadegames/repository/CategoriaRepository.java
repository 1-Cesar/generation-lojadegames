package com.projeto.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.lojadegames.model.Categoria;

/*
 * @author César Augusto
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByNomeCategoriaContainingIgnoreCase (String nomeCategoria);
}
