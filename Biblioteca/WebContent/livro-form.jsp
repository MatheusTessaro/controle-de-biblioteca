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
		<header>
			
				<div class="center">
					<h2> Cadastro </h2>
				</div>
			<nav>
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/app "
						class="nav-link">Livros</a></li>
				</ul>
			</nav>
				

		</header>
		<br>
		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">
				
					<form action="salvar" method="post">
					
					<fieldset class="form-group">
						<label>Titulo</label> 
						<input type="text"
							class="form-control"
							name="titulo" required="required"
							placeholder="digite o nome do livro">
					</fieldset>

					<fieldset class="form-group">
						<label>Autor</label> 
						<input type="text"
							class="form-control"
							name="autor" required="required"
							placeholder="digite o nome do autor">
					</fieldset>
					<button type="submit" class="btn btn-success">Salvar</button>
					
					</form>
				</div>			
			</div>
		</div>
	</body>
</html>