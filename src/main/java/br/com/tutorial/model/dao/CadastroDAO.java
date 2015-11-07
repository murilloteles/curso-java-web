package br.com.tutorial.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tutorial.model.entity.Anuncio;
import br.com.tutorial.model.entity.Categoria;
import br.com.tutorial.model.entity.UF;

public class CadastroDAO {
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("ANUNC-LOJA");
	private EntityManager em;
	
	public void salvarAnuncio(Anuncio anuncio){
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(anuncio);
		em.getTransaction().commit();
	}
	
	public List<UF> getUfs(){
		List<UF> ufs = getEntityManager().createQuery("from UF").getResultList();
		return ufs;		
	}
	
	public List<Categoria> getCategorias(){
		List<Categoria> cats = getEntityManager().createQuery("from Categoria").getResultList();
		return cats;		
	}
	
	public EntityManager getEntityManager(){
		return FACTORY.createEntityManager();
	}

}
