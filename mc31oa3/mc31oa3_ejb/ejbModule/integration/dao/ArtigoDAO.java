package integration.dao;

import java.util.List;

import javax.ejb.Local;

import business.entity.Artigo;

@Local 
public interface ArtigoDAO {
	public List<Artigo> findAll();

	public void save(final Artigo $artigo) throws Exception;
}
