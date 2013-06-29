package business.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name = "categoria")
@NamedQuery(name = "Categoria.findAll", query = "SELECT object(o) FROM Categoria o")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	public Categoria() {
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}