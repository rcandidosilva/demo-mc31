package integration.dao.jpa;

import integration.dao.RotuloDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import business.entity.Rotulo;

@Stateless
public class RotuloDAOJPA extends _DAOJPA implements RotuloDAO {

	@PersistenceContext(unitName="mc31PU")
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public List<Rotulo> findAll() {
		final Query namedQuery = super.getNamedQuery("Rotulo.findAll");
		final List<Rotulo> rotulos = namedQuery.getResultList();
		return rotulos;
	}

	public Rotulo findById(final int $id) {
		return entityManager.find(Rotulo.class, $id);
	}

	public Rotulo findByNome(final String $token) {
		final Query namedQuery = super.getNamedQuery("Rotulo.findByNome");
		namedQuery.setParameter("nome", $token);
		Rotulo rotulo = null;
		try {
			rotulo = (Rotulo) namedQuery.getSingleResult();
		} catch (final NoResultException e) {
			// do nothing
		}// try
		return rotulo;
	}

	public void save(final Rotulo $rotulo) throws Exception {
		super.save($rotulo);
	}

	@Override
	public Set<Rotulo> saveNewRotulos(final Set<String> $setTokens) {
		final Set<Rotulo> rotulos = new HashSet<Rotulo>();
		for (final String token : $setTokens) {
			Rotulo rotulo = this.findByNome(token);
			if (rotulo == null) {
				rotulo = new Rotulo();
				rotulo.setNome(token);
			}// if
			rotulos.add(rotulo);
		}// for
		return rotulos;
	}

}
