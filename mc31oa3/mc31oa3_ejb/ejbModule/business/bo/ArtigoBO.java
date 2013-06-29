package business.bo;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import business.entity.Artigo;
import business.entity.Categoria;
import business.entity.Rotulo;

@Local
public interface ArtigoBO {

	public List<Artigo> findAllArtigos();

	public List<Categoria> findAllCategorias();

	public List<Rotulo> findAllRotulos();

	public List<Artigo> findArtigosByCategoria(final Categoria $categoria);

	public List<Artigo> findArtigosByRotulo(final Rotulo $rotulo);

	public Categoria findCategoriaById(final int $categoriaId);

	public void grave(final Artigo $artigo) throws Exception;

	public Set<Rotulo> saveNewRotulos(final String $lista,
			final String $delimitador);

}