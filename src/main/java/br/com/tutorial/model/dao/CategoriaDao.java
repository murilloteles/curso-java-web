package br.com.tutorial.model.dao;

import java.util.List;

import br.com.tutorial.model.entity.Categoria;

public class CategoriaDao extends AbstractDAO<Categoria, Long> {
	
	public List<Categoria> getCategorias(){
		return buscarTodos();
	}
}
