/**/
package com.cgm.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cgm.jpa.domain.User;

@Transactional
@EnableTransactionManagement
public class AbstractDAO<E> {

	@PersistenceContext(name = "jpa")
	private EntityManager em;
	
	private final Class<E> entityClass;
	
	protected AbstractDAO(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Transactional
	public EntityManager em() {
		return em;
	}
	
	@Transactional
	public void save(final E entityToBeSaved) {
		em.persist(entityToBeSaved);
	}

	@Transactional
	public void update(final E entityToBeUpdated) {
		em.merge(entityToBeUpdated);
	}

	@Transactional
	public void remove(final E entityToBeRemoved) {
		em.remove(entityToBeRemoved);
	}

	@Transactional
	public void delete(final Long id) {
		em.remove(findById(id));
	}
	
	@Transactional
	public E findById(final Long entityId) {
		return em.find(entityClass, entityId);
	}
	
	@Transactional
	public E findByUsername(final String entityName) throws NoResultException {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<E> query = builder.createQuery(entityClass);
		Root<E> root = query.from(entityClass);
		
		query.select(root);
		query.where(builder.equal(root.get("username"), entityName));
		TypedQuery<E> typedQuery = em.createQuery(query);
		E result = typedQuery.getSingleResult();
		return result;
	}
	
	@Transactional
	public List<E> findAllMessages(User id_user) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<E> query = builder.createQuery(entityClass);
		Root<E> root = query.from(entityClass);
		
		query.select(root);
		query.where(builder.equal(root.get("user"), id_user.getId()));
		TypedQuery<E> q = em.createQuery(query);
		List<E> result = q.getResultList();
		return result;
		
	}
	
	@Transactional
	public List<E> findAllUsers(String username) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<E> query = builder.createQuery(entityClass);
		Root<E> root = query.from(entityClass);
		
		query.select(root);
		query.where(builder.notEqual(root.get("username"), username));
		TypedQuery<E> q = em.createQuery(query);
		List<E> result = q.getResultList();
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> findAll() {
		return (List<E>) em.createQuery(
				new StringBuilder().append("SELECT entity FROM ")
						.append(entityClass.getCanonicalName())
						.append(" entity ").toString()).getResultList();
	}
	
	
}

/**/