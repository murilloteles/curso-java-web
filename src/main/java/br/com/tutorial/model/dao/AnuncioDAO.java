package br.com.tutorial.model.dao;

import br.com.tutorial.model.entity.Anuncio;

/**
 * Classe respos�vel pela manipula��o das informa��es de an�ncio na base de dados.
 * @author angelo
 *
 */
public class AnuncioDAO extends AbstractDAO<Anuncio, Long> {
	
	
	public void salvarAnuncio(Anuncio anuncio){
		inserirOuAtualizar(anuncio);
	}
	
	
}
