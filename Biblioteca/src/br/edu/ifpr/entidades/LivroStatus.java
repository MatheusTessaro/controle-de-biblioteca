package br.edu.ifpr.entidades;

public enum LivroStatus {
	
	DISPONIVEL("disponivel"),
	EMPRESTADO("emprestado");
	
	
	private final String status;

	LivroStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
