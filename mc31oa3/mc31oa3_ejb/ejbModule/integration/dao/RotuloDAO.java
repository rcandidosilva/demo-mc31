package integration.dao;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import business.entity.Rotulo;

@Local
public interface RotuloDAO {
	public List<Rotulo> findAll();

	public Rotulo findById(final int $id);
	
	public Rotulo findByNome(final String $nome);

	public Set<Rotulo> saveNewRotulos(Set<String> $setTokens);

}
