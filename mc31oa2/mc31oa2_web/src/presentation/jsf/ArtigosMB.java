package presentation.jsf;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import presentation.util.BusinessDelegate;
import business.entity.Artigo;
import business.entity.Categoria;
import business.entity.Rotulo;

public class ArtigosMB extends _MB {

	private DataModel dmArtigos;
	private Artigo artigo;
	private List<SelectItem> siCategorias;
	private List<Rotulo> rotulosDisponiveis, rotulosSelecionados;
	private List<SelectItem> siRotulosDisponiveis;
	private int categoriaId;
	private Set<Integer> rotulosId;
	private String rotulosAsString;

	private BusinessDelegate delegate = BusinessDelegate.INSTANCE;
	
	public ArtigosMB() {
		this.initCmbCategorias();
		this.initDTArtigos();
		this.initNovoArtigo();
		this.initRotulos();
	}

	public String atualizeArtigos() {
		this.initDTArtigos();
		return null;
	}

	public Artigo getArtigo() {
		return this.artigo;
	}

	public int getCategoriaId() {
		return this.categoriaId;
	}

	public DataModel getDmArtigos() {
		return this.dmArtigos;
	}

	public String getRotulosAsString() {
		return this.rotulosAsString;
	}

	public List<Rotulo> getRotulosDisponiveis() {
		return this.rotulosDisponiveis;
	}

	public Set<Integer> getRotulosId() {
		return this.rotulosId;
	}

	public List<Rotulo> getRotulosSelecionados() {
		return this.rotulosSelecionados;
	}

	public List<SelectItem> getSiCategorias() {
		return this.siCategorias;
	}

	public List<SelectItem> getSiRotulosDisponiveis() {
		return this.siRotulosDisponiveis;
	}

	public String salveArtigo() {
		final Set<Rotulo> rotulos = this.delegate.saveNewRotulos(
				this.rotulosAsString, ";");
		final Categoria categoria = this.delegate
				.findCategoriaById(this.categoriaId);
		this.artigo.setCategoria(categoria);
		this.artigo.setRotulos(rotulos);
		try {
			this.delegate.grave(this.artigo);
		} catch (final Exception e) {
			this.getJsfHelper().addGlobalErrorMessage(e);
		}// try
		final String msg = String.format("Artigo %s salvo com sucesso.",
				this.artigo.getTitulo());
		this.getJsfHelper().addGlobalInfoMessage(msg, msg);
		this.initDTArtigos();
		this.initNovoArtigo();
		return null;
	}

	public void setArtigo(final Artigo $artigo) {
		this.artigo = $artigo;
	}

	public void setCategoriaId(final int $categoriaId) {
		this.categoriaId = $categoriaId;
	}

	public void setDmArtigos(final DataModel $dmArtigos) {
		this.dmArtigos = $dmArtigos;
	}

	public void setRotulosAsString(final String $rotulosAsString) {
		this.rotulosAsString = $rotulosAsString;
	}

	public void setRotulosDisponiveis(final List<Rotulo> $rotulosDisponiveis) {
		this.rotulosDisponiveis = $rotulosDisponiveis;
	}

	public void setRotulosId(final Set<Integer> $rotulosId) {
		this.rotulosId = $rotulosId;
	}

	public void setRotulosSelecionados(final List<Rotulo> $rotulosSelecionados) {
		this.rotulosSelecionados = $rotulosSelecionados;
	}

	public void setSiCategorias(final List<SelectItem> $siCategorias) {
		this.siCategorias = $siCategorias;
	}

	public void setSiRotulosDisponiveis(
			final List<SelectItem> $siRotulosDisponiveis) {
		this.siRotulosDisponiveis = $siRotulosDisponiveis;
	}

	private void initCmbCategorias() {
		this.siCategorias = new LinkedList<SelectItem>();
		final List<Categoria> categorias = this.delegate.findAllCategorias();
		for (final Categoria categoria : categorias) {
			this.siCategorias.add(new SelectItem(categoria.getId(), categoria
					.getNome()));
			this.categoriaId = categoria.getId();
		}// for
	}

	private void initDTArtigos() {
		final List<Artigo> artigos = this.delegate.findAllArtigos();
		this.dmArtigos = new ListDataModel(artigos);
	}

	private void initNovoArtigo() {
		this.artigo = new Artigo();
	}

	private void initRotulos() {
		this.rotulosDisponiveis = this.delegate.findAllRotulos();
		this.siRotulosDisponiveis = new LinkedList<SelectItem>();
		for (final Rotulo rotulo : this.rotulosDisponiveis) {
			this.siRotulosDisponiveis.add(new SelectItem(rotulo.getId(), rotulo
					.getNome()));
		}// for
	}
}
