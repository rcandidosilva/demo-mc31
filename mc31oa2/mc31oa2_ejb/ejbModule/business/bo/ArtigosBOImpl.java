package business.bo;

import integration.dao.ArtigoDAO;
import integration.dao.CategoriaDAO;
import integration.dao.RotuloDAO;
import integration.dao._DAOFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;

import business.entity.Artigo;
import business.entity.Categoria;
import business.entity.Rotulo;

@Stateless(mappedName="ejb/ArtigosBO")
public class ArtigosBOImpl extends _BO implements ArtigosBO {

	private ArtigoDAO artigoDAO = _DAOFactory.INSTANCE.getArtigoDAO();
	private CategoriaDAO categoriaDAO = _DAOFactory.INSTANCE.getCategoriaDAO();
	private RotuloDAO rotuloDAO = _DAOFactory.INSTANCE.getRotuloDAO();

	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#findAllArtigos()
	 */
	public List<Artigo> findAllArtigos() {
		return this.artigoDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#findAllCategorias()
	 */
	public List<Categoria> findAllCategorias() {
		return this.categoriaDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#findAllRotulos()
	 */
	public List<Rotulo> findAllRotulos() {
		return this.rotuloDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#findArtigosByCategoria(business.entity.Categoria)
	 */
	public List<Artigo> findArtigosByCategoria(final Categoria $categoria) {
		return null;
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#findArtigosByRotulo(business.entity.Rotulo)
	 */
	public List<Artigo> findArtigosByRotulo(final Rotulo $rotulo) {
		return null;
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#findCategoriaById(int)
	 */
	public Categoria findCategoriaById(final int $categoriaId) {
		return this.categoriaDAO.findById($categoriaId);
	}
	
	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#findCategoriaById(int)
	 */
	public Rotulo findRotuloById(final int $rotuloId) {
		return this.rotuloDAO.findById($rotuloId);
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#grave(business.entity.Artigo)
	 */
	public void grave(final Artigo $artigo) throws Exception {
		this.artigoDAO.save($artigo);
	}

	/* (non-Javadoc)
	 * @see business.bo.ArtigosBO#saveNewRotulos(java.lang.String, java.lang.String)
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
