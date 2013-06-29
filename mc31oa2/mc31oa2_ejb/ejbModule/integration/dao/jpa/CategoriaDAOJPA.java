package integration.dao.jpa;

import integration.dao.CategoriaDAO;

import java.util.List;

import javax.persistence.Query;

import business.entity.Categoria;

public class CategoriaDAOJPA extends _DAOJPA implements CategoriaDAO {
	@SuppressWarnings("unchecked")
	public List<Categoria> findAll() {
		final Query namedQuery = super.getNamedQuery("Categoria.findAll");
		final List<Categoria> artigos = namedQuery.getResultList();
		return artigos;
	}

	public Categoria findById(final int $id) {
		return this.getJpaHelper().getEntityManager()
				.find(Categoria.class, $id);
	}

	public void save(final Categoria $categoria) throws Exception {
		super.save($categoria);
	}
}
