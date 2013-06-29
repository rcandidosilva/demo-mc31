package presentation.util;

import java.util.List;
import java.util.Set;

import business.bo.ArtigosBO;
import business.entity.Artigo;
import business.entity.Categoria;
import business.entity.Rotulo;

public class BusinessDelegate {
	
	public static final BusinessDelegate INSTANCE = new BusinessDelegate();
	
	private ArtigosBO artigosBO = (ArtigosBO) ServiceLocator.INSTANCE.locateLocalEJB("java:/comp/env/ejb/ArtigosBO"); 
	
	public List<Rotulo> findAllRotulos() { 
		return artigosBO.findAllRotulos();
	}
	
	public List<Artigo> findAllArtigos() {
		return artigosBO.findAllArtigos();
	}

	public List<Categoria> findAllCategorias() {
		return artigosBO.findAllCategorias();
	}
	
	public Set<Rotulo> saveNewRotulos(final String $lista, final String $delimitador) {
		return artigosBO.saveNewRotulos($lista, $delimitador);
	}
	
	public void grave(final Artigo $artigo) throws Exception {
		artigosBO.grave($artigo);
	}
	
	public Categoria findCategoriaById(final int $categoriaId) {
		return artigosBO.findCategoriaById($categoriaId);
	}
	
	public List<Artigo> findArtigosByCategoria(final Categoria $categoria) {
		return artigosBO.findArtigosByCategoria($categoria);
	}

	public List<Artigo> findArtigosByRotulo(final Rotulo $rotulo) {
		return artigosBO.findArtigosByRotulo($rotulo);
	}
	
	public Rotulo findRotuloById(final int $id) {
		return artigosBO.findRotuloById($id);
	}

}
