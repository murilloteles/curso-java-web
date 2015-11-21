package br.com.tutorial.model.entity;

import java.io.Serializable;

/**
 * Esta classe define a estrutura b�sica para as entidade que ser�o mapeadas pelo JPA.
 * @author angelo.pereira
 *
 */
public abstract class BaseEntity {
	
	/**
	 * Retorna o identificador da entidade.<br />
	 * <b>Nota:</b> M�todo utilizado para padronizar a chave prim�ria da entidade. 
	 * @return
	 */
	public abstract Serializable getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	/**
	 * M�todo marcado como final para garantir que seja usado apenas o id da
	 * entidade como atribuito para compara��o.
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		Class<?> clazz = HibernateProxyExtractor.extractClass(obj);

		if (getClass() != clazz)
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	/*
	 * Implementa��o b�sica do toString(). <br />
	 * Retorna o nome da classe e o id da entidade. <br />
	 * Este m�todo deve ser sobrescrito para fornecer uma representa��o mais
	 * intuitiva sobre a entidade.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getName()).append("[id = ").append(getId())
				.append("]");
		return s.toString();
	}
	


}
