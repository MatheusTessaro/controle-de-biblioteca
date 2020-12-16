package br.edu.ifpr.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpr.entidades.Autor;
import br.edu.ifpr.entidades.Livro;
import br.edu.ifpr.repositorio.ILivroRepositorio;
import br.edu.ifpr.repositorio.LivroRepositorioMemoria;

@SuppressWarnings("serial")
@WebServlet("/livros")
public class LivrosServlet extends HttpServlet{
	
	ILivroRepositorio repositorio = new LivroRepositorioMemoria();
	
	@Override
	public void init() throws ServletException {
		Livro livro1 = new Livro();
		Autor autor = new Autor();
		livro1.setTitulo("livro1");
		autor.setNome("Matheus");
		livro1.setAutor(autor);
		repositorio.cadastrar(livro1);
		
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getServletPath();

			switch (action) {
			case "/novo":
				cadastrar(req, resp);
				break;
			case "/salvar":
				salvar(req, resp);
				break;
			case "/excluir":
				excluir(req, resp);
				break;
			case "/alterar":
				alterarStatus(req, resp);
				break;
			default:
				listarLivros(req, resp);
				break;
			}
	}

	private void excluir(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		
		repositorio.excluir(id);
		
		//redirecionar para a tela inicial
		resp.sendRedirect("app");
		
	}


	private void alterarStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = req.getParameter("status");
		
		repositorio.alterarStatus(id, status);
		
		resp.sendRedirect("app");		
	}


	private void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tituloLivro = req.getParameter("titulo");
		String nomeAutor = req.getParameter("autor");
		
		Livro livro = new Livro();
		Autor autor = new Autor();
		autor.setNome(nomeAutor);
		livro.setTitulo(tituloLivro);
		livro.setAutor(autor);
		
		
		try {
			repositorio.cadastrar(livro);	
			resp.sendRedirect("app");
		
		} catch(IllegalArgumentException e) {
						
			req.setAttribute("erros", e.getMessage());
			RequestDispatcher disp = req.getRequestDispatcher("app");
			disp.forward(req, resp);
		}
	}		
	


	private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/livro-form.jsp");
		dispatcher.forward(req, resp);
	}

	private void listarLivros(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listaLivros", repositorio.listar());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
	
}
