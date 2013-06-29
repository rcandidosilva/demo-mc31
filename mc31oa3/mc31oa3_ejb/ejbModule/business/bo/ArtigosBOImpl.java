package business.bo;

import integration.dao.ArtigoDAO;
import integration.dao.CategoriaDAO;
import integration.dao.RotuloDAO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.entity.Artigo;
import business.entity.Categoria;
import business.entity.Rotulo;

@Stateless
public class ArtigosBOImpl extends _BO implements ArtigoBO {

	@EJB
	private ArtigoDAO artigoDAO;
	
	@EJB
	private CategoriaDAO categoriaDAO;
	
	@EJB
	private RotuloDAO rotuloDAO;

	/* (non-Javadoc)
	 * @see business.bo.ArtigoBO#findAllArtigos()
	 */
	public List<Artigo> findAllArtigos() {
		return this.artigoDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigoBO#findAllCategorias()
	 */
	public List<Categoria> findAllCategorias() {
		return this.categoriaDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigoBO#findAllRotulos()
	 */
	public List<Rotulo> findAllRotulos() {
		return this.rotuloDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigoBO#findArtigosByCategoria(business.entity.Categoria)
	 */
	public List<Artigo> findArtigosByCategoria(final Categoria $categoria) {
		return null;
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigoBO#findArtigosByRotulo(business.entity.Rotulo)
	 */
	public List<Artigo> findArtigosByRotulo(final Rotulo $rotulo) {
		return null;
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigoBO#findCategoriaById(int)
	 */
	public Categoria findCategoriaById(final int $categoriaId) {
		return this.categoriaDAO.findById($categoriaId);
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigoBO#grave(business.entity.Artigo)
	 */
	public void grave(final Artigo $artigo) throws Exception {
		this.artigoDAO.save($artigo);
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigoBO#saveNewRotulos(java.lang.String, java.lang.String)
	 */
	public Set<Rotulo> saveNewRotulos(final String $lista,
			final String $delimitador) {
		Set<Rotulo> set = new HashSet<Rotulo>();
		if (($lista != null) && ($lista.trim().length() > 0)) {
			final String[] tokens = $lista.split($delimitador);
			final Set<String> setTokens = new HashSet<String>(Arrays
					.asList(tokens));
			set = this.rotuloDAO.saveNewRotulos(setTokens);
		}// if
		return set;
	}

}
