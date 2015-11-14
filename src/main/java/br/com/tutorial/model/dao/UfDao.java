package br.com.tutorial.model.dao;

import java.util.List;

import br.com.tutorial.model.entity.UF;

public class UfDao extends AbstractDAO<UF, Long>{	
	public List<UF> getUfs(){
		return buscarTodos();
	}
}
