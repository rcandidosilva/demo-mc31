package integration.dao;

import java.util.List;
import java.util.Set;

import business.entity.Rotulo;

public interface RotuloDAO {
	public List<Rotulo> findAll();

	public Rotulo findByNome(final String $nome);

	public Set<Rotulo> saveNewRotulos(Set<String> $setTokens);

}
