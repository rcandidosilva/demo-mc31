package integration.dao.jpa;

import integration.dao.CategoriaDAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import business.entity.Categoria;

@Stateless
public class CategoriaDAOJPA extends _DAOJPA implements CategoriaDAO {
	
	@PersistenceContext(unitName="mc31PU")
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> findAll() {
		final Query namedQuery = super.getNamedQuery("Categoria.findAll");
		final List<Categoria> artigos = namedQuery.getResultList();
		return artigos;
	}

	public Categoria findById(final int $id) {
		return entityManager.find(Categoria.class, $id);
	}

	public void save(final Categoria $categoria) throws Exception {
		super.save($categoria);
	}
}
