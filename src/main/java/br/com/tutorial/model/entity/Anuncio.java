package br.com.tutorial.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "anuncio")
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_anuncio")
	private Long id;
	@ManyToOne
	@JoinColumn(referencedColumnName="id_categoria", name="id_categoria")
	private Categoria categoria;
	@Column
	private String titulo;
	@Column
	private String descricao;
	@Column(name="sigla_uf")
	private String estado;
	@Column
	private String pessoa;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	@Column
	private String email;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}