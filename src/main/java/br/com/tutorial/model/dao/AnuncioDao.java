package br.com.tutorial.model.dao;

import br.com.tutorial.model.entity.Anuncio;

public class AnuncioDao extends AbstractDAO<Anuncio, Long>{
	
	public void inserirAnuncio(Anuncio anuncio){
		inserir(anuncio);
	}
	
	public Anuncio atualizarAnuncio(Anuncio anuncio){
		return atualizar(anuncio);
	}
}
