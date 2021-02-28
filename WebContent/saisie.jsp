<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%
 	String username = (String)session.getAttribute("login");
 	if(username == null ){
		response.sendRedirect("index.jsp");
	} 
 %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sasie des comptes bancaires</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
		<form action="Saisie" method="post">
			<table class="table table-striped" style="margin: 0 auto;width:30%;margin-top:3%;">
				<tr>
					<td colspan="2"><center>Sasie d'un nouveau compte bancaire</center></td>
				</tr>
				<tr>
					<td>Solde</td>
					<td><input type="text" name="Solde" class="form-control" ></td>
				</tr>
				<tr>
					<td>Propriétaire</td>
					<td><input type="text" name="Proprietaire" class="form-control"></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<input type="submit" value="Valider" class="btn btn-primary">
							<input type="reset" value="Annuler"  class="btn btn-danger">
						</center>	
					</td>
				</tr>
			</table>
		</form>
</body>
</html>