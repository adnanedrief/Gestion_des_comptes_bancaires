<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%
 	String vusername = (String)session.getAttribute("login");
	if(vusername == null){
		vusername="";
	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="saisie.jsp" >Ajouter un compte</a></li>
				<li class="nav-item "><a class="nav-link" href="consultation.jsp" >Consulter tous les comptes</a></li>
				<li class="nav-item "><a class="nav-link" href="recherche.jsp" >Rechercher un compte</a> </li>
				<li class="nav-item "><a class="nav-link" href="deconnexion.jsp" >Déconnexion[<%=vusername %>]</a></li>
			</ul>
	</nav>
</body>
</html>