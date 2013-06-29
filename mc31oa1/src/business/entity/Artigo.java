package business.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_artigo")
@NamedQueries( { @NamedQuery(name = "Artigo.findAll", query = "SELECT object(o) FROM Artigo o") })
public class Artigo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria")
	private Categoria categoria;

	private String autor;
	private String conteudo;
	private String titulo;
	private String endereco;
	private String resumo;
	private String imagem;

	@Temporal(TemporalType.DATE)
	@Column(name = "dtPublicacao")
	private Date dataDePublicacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dtCriacao")
	private Date dataDeCriacao;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "artigo_rotulo", joinColumns = { @JoinColumn(name = "artigo"), }, inverseJoinColumns = { @JoinColumn(name = "rotulo"), })
	private Set<Rotulo> rotulos;

	public Artigo() {
	}

	public String getAutor() {
		return this.autor;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public String getConteudo() {
		return this.conteudo;
	}

	public Date getDataDeCriacao() {
		return this.dataDeCriacao;
	}

	public Date getDataDePublicacao() {
		return this.dataDePublicacao;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public int getId() {
		return this.id;
	}

	public String getImagem() {
		return this.imagem;
	}

	public String getResumo() {
		return this.resumo;
	}

	public Set<Rotulo> getRotulos() {
		return this.rotulos;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setAutor(final String autor) {
		this.autor = autor;
	}

	public void setCategoria(final Categoria categoria) {
		this.categoria = categoria;
	}

	public void setConteudo(final String conteudo) {
		this.conteudo = conteudo;
	}

	public void setDataDeCriacao(final Date $dataDeCriacao) {
		this.dataDeCriacao = $dataDeCriacao;
	}

	public void setDataDePublicacao(final Date $dataDePublicacao) {
		this.dataDePublicacao = $dataDePublicacao;
	}

	public void setEndereco(final String $endereco) {
		this.endereco = $endereco;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setImagem(final String $imagem) {
		this.imagem = $imagem;
	}

	public void setResumo(final String $resumo) {
		this.resumo = $resumo;
	}

	public void setRotulos(final Set<Rotulo> rotulos) {
		this.rotulos = rotulos;
		if (rotulos != null) {
			for (final Rotulo rotulo : rotulos) {
				rotulo.setArtigos(Collections.singleton(this));
			}// for
		}// if
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

}