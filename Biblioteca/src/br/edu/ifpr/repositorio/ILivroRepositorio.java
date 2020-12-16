package br.edu.ifpr.repositorio;

import java.util.List;

import br.edu.ifpr.entidades.Livro;

public interface ILivroRepositorio {
	
	public Livro cadastrar(Livro livro) throws IllegalArgumentException;
	
	public List<Livro> listar();
	
	public Livro buscar(String id) throws IllegalArgumentException;

	public void alterarStatus(String id, String status) throws IllegalArgumentException;
	
	public void excluir(String id) throws IllegalArgumentException;
	
}
