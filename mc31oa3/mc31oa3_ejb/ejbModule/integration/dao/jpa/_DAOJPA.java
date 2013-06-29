package integration.dao.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public abstract class _DAOJPA {

	protected abstract EntityManager getEntityManager();

	public void executeUpdate(final _DAOCommand $daoCommand) {
		final EntityManager entityManager = getEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		$daoCommand.execute(entityManager);
		transaction.commit();
		entityManager.close();
	}

	public Query getNamedQuery(final String $namedQuery) {
		final EntityManager entityManager = getEntityManager();
		return entityManager.createNamedQuery($namedQuery);
	}

	public void remove(final Serializable $serializable) {
		final EntityManager entityManager = getEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove($serializable);
		transaction.commit();
		entityManager.close();
	}

	public void save(final Serializable $serializable) throws Exception {
		final EntityManager entityManager = getEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist($serializable);
		transaction.commit();
		entityManager.close();
	}

}
