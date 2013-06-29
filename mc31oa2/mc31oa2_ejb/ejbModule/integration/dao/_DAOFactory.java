package integration.dao;

import integration.dao.jpa.ArtigoDAOJPA;
import integration.dao.jpa.CategoriaDAOJPA;
import integration.dao.jpa.JPAHelper;
import integration.dao.jpa.RotuloDAOJPA;

public enum _DAOFactory {

	INSTANCE;

	private RotuloDAOJPA rotuloDAO;
	private CategoriaDAOJPA categoriaDAO;
	private ArtigoDAOJPA artigoDAO;

	private _DAOFactory() {
		final JPAHelper helper = JPAHelper.INSTANCE;
		this.artigoDAO = new ArtigoDAOJPA();
		this.artigoDAO.setJpaHelper(helper);
		this.categoriaDAO = new CategoriaDAOJPA();
		this.categoriaDAO.setJpaHelper(helper);
		this.rotuloDAO = new RotuloDAOJPA();
		this.rotuloDAO.setJpaHelper(helper);
	}

	public ArtigoDAOJPA getArtigoDAO() {
		return this.artigoDAO;
	}

	public CategoriaDAOJPA getCategoriaDAO() {
		return this.categoriaDAO;
	}

	public RotuloDAOJPA getRotuloDAO() {
		return this.rotuloDAO;
	}
}
