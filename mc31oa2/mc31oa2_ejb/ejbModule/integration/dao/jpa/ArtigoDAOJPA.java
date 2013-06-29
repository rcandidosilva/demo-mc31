package integration.dao.jpa;

import integration.dao.ArtigoDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import business.entity.Artigo;
import business.entity.Rotulo;

public class ArtigoDAOJPA extends _DAOJPA implements ArtigoDAO {

	@SuppressWarnings("unchecked")
	public List<Artigo> findAll() {
		final Query namedQuery = super.getNamedQuery("Artigo.findAll");
		final List<Artigo> artigos = namedQuery.getResultList();
		return artigos;
	}

	@Override
	public void save(final Artigo $artigo) throws Exception {
		super.save($artigo);
	}

	private void savex(final Artigo $artigo) {
		final _DAOCommand dc = new _DAOCommand() {
			public void execute(final EntityManager $entityManager) {
				for (final Rotulo rotulo : $artigo.getRotulos()) {
					if (rotulo.getId() == 0) {
						$entityManager.persist(rotulo);
					} else {
						$entityManager.merge(rotulo);
					}// if
				}// for
				$entityManager.persist($artigo);
			}// execute
		};
		this.executeUpdate(dc);
	}

}
