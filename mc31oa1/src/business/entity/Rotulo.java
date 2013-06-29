package business.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "rotulo")
@NamedQueries( {
		@NamedQuery(name = "Rotulo.findAll", query = "SELECT object(o) FROM Rotulo o"),
		@NamedQuery(name = "Rotulo.findByNome", query = "SELECT object(o) FROM Rotulo o WHERE o.nome = :nome") })
public class Rotulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	@ManyToMany(mappedBy = "rotulos")
	private Set<Artigo> artigos;

	public Rotulo() {
	}

	public Set<Artigo> getArtigos() {
		return this.artigos;
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setArtigos(final Set<Artigo> artigos) {
		this.artigos = artigos;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}