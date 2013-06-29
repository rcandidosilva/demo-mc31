package integration.dao.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import business.entity.Artigo;

public class _DAOJPA {
	private JPAHelper jpaHelper;

	public void executeUpdate(final _DAOCommand $daoCommand) {
		final EntityManager entityManager = this.getJpaHelper()
				.getEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		$daoCommand.execute(entityManager);
		transaction.commit();
		entityManager.close();
	}

	public JPAHelper getJpaHelper() {
		return this.jpaHelper;
	}

	public Query getNamedQuery(final String $namedQuery) {
		final EntityManager entityManager = this.getJpaHelper()
				.getEntityManager();
		return entityManager.createNamedQuery($namedQuery);
	}

	public void remove(final Serializable $serializable) {
		final EntityManager entityManager = this.getJpaHelper()
				.getEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove($serializable);
		transaction.commit();
		entityManager.close();
	}

	public void save(Artigo artigo) throws Exception {
		final EntityManager entityManager = this.getJpaHelper()
				.getEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(artigo);
		
		entityManager.merge(artigo);
		
		transaction.commit();
		entityManager.close();
	}

	public void setJpaHelper(final JPAHelper $jpaHelper) {
		this.jpaHelper = $jpaHelper;
	}
}
