package business.bo;

import integration.dao.ArtigoDAO;
import integration.dao.CategoriaDAO;
import integration.dao.RotuloDAO;
import integration.dao.jpa.ArtigoDAOJPA;
import integration.dao.jpa.CategoriaDAOJPA;
import integration.dao.jpa.RotuloDAOJPA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import business.entity.Artigo;
import business.entity.Categoria;
import business.entity.Rotulo;

public class ArtigosBO extends _BO {

	private ArtigoDAO artigoDAO;
	private CategoriaDAO categoriaDAO;
	private RotuloDAO rotuloDAO;

	public List<Artigo> findAllArtigos() {
		return this.artigoDAO.findAll();
	}

	public List<Categoria> findAllCategorias() {
		return this.categoriaDAO.findAll();
	}

	public List<Rotulo> findAllRotulos() {
		return this.rotuloDAO.findAll();
	}

	public List<Artigo> findArtigosByCategoria(final Categoria $categoria) {
		return null;
	}

	public List<Artigo> findArtigosByRotulo(final Rotulo $rotulo) {
		return null;
	}

	public Categoria findCategoriaById(final int $categoriaId) {
		return this.getCategoriaDAO().findById($categoriaId);
	}

	public ArtigoDAO getArtigoDAO() {
		return this.artigoDAO;
	}

	public CategoriaDAO getCategoriaDAO() {
		return this.categoriaDAO;
	}

	public RotuloDAO getRotuloDAO() {
		return this.rotuloDAO;
	}

	public void grave(final Artigo $artigo) throws Exception {
		this.artigoDAO.save($artigo);
	}

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

	public void setArtigoDAO(final ArtigoDAOJPA $artigoDAO) {
		this.artigoDAO = $artigoDAO;
	}

	public void setCategoriaDAO(final CategoriaDAOJPA $categoriaDAO) {
		this.categoriaDAO = $categoriaDAO;
	}

	public void setRotuloDAO(final RotuloDAOJPA $rotuloDAO) {
		this.rotuloDAO = $rotuloDAO;
	}

}
