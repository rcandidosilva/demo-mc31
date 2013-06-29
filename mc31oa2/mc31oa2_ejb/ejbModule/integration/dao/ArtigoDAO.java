package integration.dao;

import java.util.List;

import business.entity.Artigo;

public interface ArtigoDAO {
	public List<Artigo> findAll();

	public void save(final Artigo $artigo) throws Exception;
}
