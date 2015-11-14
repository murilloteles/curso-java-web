package br.com.tutorial.model.dao;

import br.com.tutorial.model.entity.Usuario;

public class UsuarioDao extends AbstractDAO<Usuario, Long>{

	public void inserirUsuario(Usuario usuario){
		inserir(usuario);
	}
	
	public Usuario atualizarUsuario(Usuario usuario){
		return atualizar(usuario);
	}
}
