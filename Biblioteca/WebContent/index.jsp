<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@ page import="br.edu.ifpr.entidades.Livro"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Livros</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />

</head>
<body>

	<%  
		List<Livro> listaLivrosJSP = new ArrayList<Livro>();
	
		if(request.getAttribute("listaLivros") != null){
			listaLivrosJSP = (List<Livro>) request.getAttribute("listaLivros");
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		
		String mensagemErro = (String) request.getAttribute("erros");
		
	%>


	<div class="container">
	
		<h2>Lista de Livros</h2>
		<div class="container text-left">

			<a href="<%=request.getContextPath()%>/novo" class="btn btn-success">
				Novo Livro
			</a>
		</div>
		
	
		<table class="table">
			<thead>
				<tr>
					<th>#id</th>
					<th>titulo</th>
					<th>autor</th>
					<th>data</th>
					<th>status</th>
					<th>operações</th>
				</tr>
			</thead>
			
			<!-- taglib -->
			
			<% for(Livro livro: listaLivrosJSP) { %>
			<tr>
				<td><% out.print(livro.getId()); %></td>
				<td><%= livro.getTitulo() %></td>
				<td><%= livro.getAutor().getNome() %></td>
				<td><%= dateFormat.format(livro.getDataCriacao()) %> </td>
				<td><%= livro.getStatus().getStatus() %></td>
				
				<td>
					<a href="<%=request.getContextPath()%>/alterar?id=<%= livro.getId() %>&status=<%=livro.getStatus().getStatus()%>">alterar status</a>
					
					
					<a href="<%=request.getContextPath()%>/excluir?id=<%= livro.getId() %>">excluir</a>
					
				</td>
			</tr>
			
			<%} %>
		
			
		</table>
	
	
	</div>


</body>
</html>