package integration.dao.jpa;

import integration.dao._DAOFactory;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;
import business.entity.Artigo;
import business.entity.Categoria;
import business.entity.Rotulo;

public class TestArtigoDAO extends TestCase {
	private final ArtigoDAOJPA artigoDAO = _DAOFactory.INSTANCE.getArtigoDAO();

	public void testFindAll() {
		final List<Artigo> artigos = this.artigoDAO.findAll();
		Assert.assertEquals(5, artigos.size());
	}

	public void xtestSave() throws Exception {
		final Artigo artigo = new Artigo();
		artigo.setAutor("Vinny");
		final Categoria categoria = new Categoria();
		categoria.setId(1);
		artigo.setCategoria(categoria);
		artigo.setConteudo("texto do artigo");
		artigo.setDataDeCriacao(new Date());
		artigo.setDataDePublicacao(new Date());
		final Set<Rotulo> setRotulos = new HashSet<Rotulo>();
		final Rotulo rotuloJSF = new Rotulo();
		rotuloJSF.setNome("jsfx");
		setRotulos.add(rotuloJSF);
		final Rotulo rotuloCairngorm = new Rotulo();
		rotuloCairngorm.setNome("flexx");
		setRotulos.add(rotuloCairngorm);
		artigo.setRotulos(setRotulos);
		artigo.setTitulo("Titulo do artigo do vinny");
		this.artigoDAO.save(artigo);
		Assert.assertTrue(artigo.getId() > 0);
		Assert.assertTrue(rotuloCairngorm.getId() > 0);
		Assert.assertTrue(rotuloJSF.getId() > 0);

	}
}
