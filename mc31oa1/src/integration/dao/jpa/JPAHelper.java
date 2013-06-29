package integration.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum JPAHelper {
	INSTANCE;

	private EntityManagerFactory entityManagerFactory;

	JPAHelper() {
		this.entityManagerFactory = Persistence
				.createEntityManagerFactory("mc31PU");
	}

	public EntityManager getEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}
}
