package integration.dao;

import java.util.List;

import javax.ejb.Local;

import business.entity.Categoria;

@Local
public interface CategoriaDAO {
	public List<Categoria> findAll();

	public Categoria findById(final int $id);
}
