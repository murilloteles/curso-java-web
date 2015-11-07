package br.com.tutorial.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.com.tutorial.model.CadastroDTO;
import br.com.tutorial.model.dao.CadastroDAO;
import br.com.tutorial.model.entity.Categoria;
import br.com.tutorial.model.entity.UF;

@ManagedBean(name="cadastro")
@RequestScoped
public class CadastroController {
	
	private CadastroDTO cdto = new CadastroDTO();
	
	public List<UF> getUfs(){
		CadastroDAO dao = new CadastroDAO();
		return dao.getUfs();
	}
	
	public List<Categoria> getCategorias(){
		CadastroDAO dao = new CadastroDAO();
		return dao.getCategorias();
	}
	
	public String salvar(){
		CadastroDAO dao = new CadastroDAO();
		dao.salvarAnuncio(cdto.getAnuncio());
		return "index";
	}
	
	public CadastroDTO getCdto() {
		return cdto;
	}

	public void setCdto(CadastroDTO cdto) {
		this.cdto = cdto;
	}

}
