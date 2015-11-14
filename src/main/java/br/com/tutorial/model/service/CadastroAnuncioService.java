package br.com.tutorial.model.service;

import java.util.List;

import br.com.tutorial.model.CadastroDTO;
import br.com.tutorial.model.dao.AnuncioDao;
import br.com.tutorial.model.dao.CategoriaDao;
import br.com.tutorial.model.dao.UfDao;
import br.com.tutorial.model.dao.UsuarioDao;
import br.com.tutorial.model.entity.Anuncio;
import br.com.tutorial.model.entity.Categoria;
import br.com.tutorial.model.entity.UF;
import br.com.tutorial.model.entity.Usuario;

public class CadastroAnuncioService {
	
	public void inserirUsuario(CadastroDTO cadastro){
		UsuarioDao dao = new UsuarioDao();
		dao.inserirUsuario(cadastro.getUsuario());
	}
	
	public Usuario atualizarUsuario(CadastroDTO cadastro){
		UsuarioDao dao = new UsuarioDao();
		return dao.atualizarUsuario(cadastro.getUsuario());
	}
	
	public void inserirAnuncio(CadastroDTO cadastro){
		inserirUsuario(cadastro);
		Anuncio anuncio = cadastro.getAnuncio();
		anuncio.setUsuario(cadastro.getUsuario());
		AnuncioDao dao = new AnuncioDao();
		dao.inserirAnuncio(anuncio);
	}
	
	public Anuncio atualizarAnuncio(CadastroDTO cadastro){
		AnuncioDao dao = new AnuncioDao();
		return dao.atualizarAnuncio(cadastro.getAnuncio());
	}
	
	public List<Categoria> getCategoria(){
		CategoriaDao dao = new CategoriaDao();
		
		return dao.getCategorias();
	}

	public List<UF> getUfs(){
		UfDao dao = new UfDao();
		
		return dao.getUfs();
	}
}
