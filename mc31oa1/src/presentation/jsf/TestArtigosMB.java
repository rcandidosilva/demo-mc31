package presentation.jsf;

import java.util.Date;

import junit.framework.TestCase;
import business.entity.Artigo;
import business.entity.Categoria;

public class TestArtigosMB extends TestCase {
	public void testSalveArquivo() {
		final ArtigosMB mb = new ArtigosMB();
		final Artigo artigo = new Artigo();
		final Categoria categoria = new Categoria();
		categoria.setId(2);
		artigo.setAutor("testCase 1");
		artigo.setCategoria(categoria);
		artigo.setConteudo("categoria 22");
		artigo.setDataDeCriacao(new Date());
		artigo.setDataDePublicacao(new Date());
		artigo.setTitulo("titulo testCase 1");
		mb.setArtigo(artigo);
		mb.salveArtigo();
	}
}
