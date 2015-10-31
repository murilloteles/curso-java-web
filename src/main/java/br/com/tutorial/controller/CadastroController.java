package br.com.tutorial.controller;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean(name="cadastro")
public class CadastroController {
	
	private Date data;
	
	@PostConstruct
	public void init() {
		data = Calendar.getInstance().getTime();
	}

	public String getMessage() {
		return "Cadastro iniciado: "  + data;
	}
}
