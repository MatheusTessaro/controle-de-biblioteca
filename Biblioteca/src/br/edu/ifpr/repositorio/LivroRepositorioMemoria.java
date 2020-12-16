package br.edu.ifpr.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.entidades.Livro;
import br.edu.ifpr.entidades.LivroStatus;

public class LivroRepositorioMemoria implements ILivroRepositorio{
	
	private static List<Livro> livros = new ArrayList<Livro>();

	@Override
	public List<Livro> listar() {

		return livros;
	}
	
	
	@Override
	public Livro buscar(String id) throws IllegalArgumentException{
		for (Livro livro : livros) {
			if(id.equals(livro.getId())) {
				return livro;
			}
		}
		
		throw new IllegalArgumentException("id inexistente");
	}
	
	
	@Override
	public Livro cadastrar(Livro livro) throws IllegalArgumentException{
		if(livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
			throw new IllegalArgumentException("O livro precisa ter um titulo");
		}
		
		if(livro.getAutor() == null) {
			throw new IllegalArgumentException("O livro precisa ter um autor");
		}
		
		livros.add(livro);
		
		return livro;
	}

	@Override
	public void alterarStatus(String id, String status) throws IllegalArgumentException {
		Livro livro = this.buscar(id);
		
		switch(status) {
		case "emprestado":
			livro.setStatus(LivroStatus.DISPONIVEL);
			break;
		
		case "disponivel":
			livro.setStatus(LivroStatus.EMPRESTADO);
			break;
			
		default:
			throw new IllegalArgumentException("Status inválido");
	}
		
	}

	@Override
	public void excluir(String id)throws IllegalArgumentException {
		for(int index = 0; index < livros.size(); index++) {
			
			Livro livro = livros.get(index);
			
			if(livro.getId().equals(id)) {
				livros.remove(index);
				
			}
		}
		
	}




}
