package br.edu.ifpr.entidades;

import java.util.Date;
import java.util.UUID;

public class Livro {
	
	private String id;
	private String titulo;
	private Date dataCriacao;
	private LivroStatus status;
	private Autor autor;

	
	
	public Livro(){
		this.id = UUID.randomUUID().toString();
		this.dataCriacao = new Date();
		this.setStatus(LivroStatus.DISPONIVEL);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public LivroStatus getStatus() {
		return status;
	}


	public void setStatus(LivroStatus status) {
		this.status = status;
	}


}
