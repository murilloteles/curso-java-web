package br.com.tutorial.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.tutorial.model.entity.Anuncio;

public class CadastroDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Anuncio anuncio;

	public Anuncio getAnuncio() {
		if(anuncio == null)
			this.anuncio = new Anuncio();
		
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}


}
