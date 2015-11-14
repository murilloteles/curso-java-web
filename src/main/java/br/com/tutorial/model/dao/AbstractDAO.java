package br.com.tutorial.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDAO<T, PK extends Serializable> {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PU-UDF");
	private EntityManager em;
	
	private final Class<T> TipoEntidade;

	public AbstractDAO() {
		em = getEntityManager();
		TipoEntidade = getTipoEntidade();
	}
	
	protected void inserir(T entidade){
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}
	
	protected T atualizar(T entidade){
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		return entidade;
	}
	
	protected T buscar(PK pk){
		return em.find(TipoEntidade, pk);
	}
	
	protected void apagarPorId(PK id) {
		em.getTransaction().begin();
		em.remove(buscar(id));
		em.getTransaction().commit();
	}

	/**
	 * Exclui a entidade da base de dados.
	 * 
	 * @param entity
	 */
	protected void apagar(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	protected List<T> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(TipoEntidade);
		Root<T> rootEntry = cq.from(TipoEntidade);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	private Class<T> getTipoEntidade() {
		Type superClass;

		// Get the generic super class of the super class if it's a cglib proxy
		if (getClass().getName().contains("$$EnhancerByCGLIB$$")) {
			superClass = getClass().getSuperclass().getGenericSuperclass();
		} else {
			superClass = getClass().getGenericSuperclass();
		}

		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) superClass;
			if (parameterizedType.getActualTypeArguments().length > 0) {
				return (Class<T>) parameterizedType.getActualTypeArguments()[0];
			} else {
				throw new RuntimeException("Não foi possível identificar o tipo da entidade: " + superClass);
			}

		} else {
			throw new RuntimeException("Não foi possível identificar o tipo da entidade: " + superClass);
		}

	}
	
	public EntityManager getEntityManager() {
		if (em == null || !em.isOpen()) {
			em = EMF.createEntityManager();
		}
		return em;
	}
	
	
}
