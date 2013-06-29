package presentation.jsf;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import business.bo.ArtigosBO;
import business.bo._BOFactory;
import business.entity.Artigo;
import business.entity.Categoria;
import business.entity.Rotulo;

public class ArtigosMB extends _MB {

	private ArtigosBO artigosBO;
	private DataModel dmArtigos;
	private Artigo artigo;
	private int categoriaId;
	private List<SelectItem> siCategorias;
	private List<Rotulo> rotulosDisponiveis, rotulosSelecionados;
	private List<SelectItem> siRotulosDisponiveis;
	private Set<Integer> rotulosId;
	private String rotulosAsString;

	public ArtigosMB() {
	}

	public String atualizeArtigos() {
		this.initDTArtigos();
		return null;
	}

	public Artigo getArtigo() {
		return this.artigo;
	}

	public ArtigosBO getArtigosBO() {
		return this.artigosBO;
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

	public String prepareParaCriar() {
		final String outcome = "artigo";
		return outcome;
	}

	public String salveArtigo() {
		final Set<Rotulo> rotulos = this.getArtigosBO().saveNewRotulos(
				this.rotulosAsString, ";");
		final Categoria categoria = this.artigosBO
				.findCategoriaById(this.categoriaId);
		this.artigo.setCategoria(categoria);
		this.artigo.setRotulos(rotulos);
		try {
			this.artigosBO.grave(this.artigo);
		} catch (final Exception e) {
			this.getJsfHelper().addGlobalErrorMessage(e);
		}// try
		final String msg = String.format("Artigo %s salvo com sucesso.",
				this.artigo.getTitulo());
		this.getJsfHelper().addGlobalInfoMessage(msg, msg);
		this.initDTArtigos();
		this.initNovoArtigo();
		return "artigos";
	}

	public void setArtigo(final Artigo $artigo) {
		this.artigo = $artigo;
	}

	public void setArtigosBO(final ArtigosBO $artigosBO) {
		this.artigosBO = $artigosBO;
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

	@PostConstruct
	private void init() {
		this.artigosBO = _BOFactory.INSTANCE.getArtigosBO();
		this.initCmbCategorias();
		this.initDTArtigos();
		this.initNovoArtigo();
		this.initRotulos();
	}

	private void initCmbCategorias() {
		this.siCategorias = new LinkedList<SelectItem>();
		final List<Categoria> categorias = this.artigosBO.findAllCategorias();
		for (final Categoria categoria : categorias) {
			this.siCategorias.add(new SelectItem(categoria.getId(), categoria
					.getNome()));
			this.categoriaId = categoria.getId();
		}// for
	}

	private void initDTArtigos() {
		final List<Artigo> artigos = this.artigosBO.findAllArtigos();
		this.dmArtigos = new ListDataModel(artigos);
	}

	private void initNovoArtigo() {
		this.artigo = new Artigo();
	}

	private void initRotulos() {
		this.rotulosDisponiveis = this.artigosBO.findAllRotulos();
		this.siRotulosDisponiveis = new LinkedList<SelectItem>();
		for (final Rotulo rotulo : this.rotulosDisponiveis) {
			this.siRotulosDisponiveis.add(new SelectItem(rotulo.getId(), rotulo
					.getNome()));
		}// for
	}
}
