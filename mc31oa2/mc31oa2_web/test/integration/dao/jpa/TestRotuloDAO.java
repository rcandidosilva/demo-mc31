package integration.dao.jpa;

import integration.dao.RotuloDAO;
import integration.dao._DAOFactory;
import junit.framework.Assert;
import junit.framework.TestCase;
import business.entity.Rotulo;

public class TestRotuloDAO extends TestCase {
	private RotuloDAO rotuloDAO;

	public void testFindByNome() {
		final String nome = "jsf";
		final Rotulo rotulo = this.rotuloDAO.findByNome(nome);
		Assert.assertEquals(nome, rotulo.getNome());
	}

	@Override
	protected void setUp() throws Exception {
		this.rotuloDAO = _DAOFactory.INSTANCE.getRotuloDAO();
	}

	@Override
	protected void tearDown() throws Exception {
		this.rotuloDAO = null;
	}
}
