package br.edu.ifpr.entidades;

import java.util.UUID;

public class Autor {

	private String id;
	private String nome;
	
	
	public Autor() {
		this.id = UUID.randomUUID().toString();
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
