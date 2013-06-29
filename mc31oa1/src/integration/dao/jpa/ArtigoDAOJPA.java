package integration.dao.jpa;

import integration.dao.ArtigoDAO;

import java.util.List;

import javax.persistence.Query;

import business.entity.Artigo;

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

}
