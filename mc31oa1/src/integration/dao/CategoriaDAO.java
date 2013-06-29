package integration.dao;

import java.util.List;

import business.entity.Categoria;

public interface CategoriaDAO {
	public List<Categoria> findAll();

	public Categoria findById(final int $id);
}
