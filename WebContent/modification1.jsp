<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification des informations du compte </title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
		<form action="Modification1" method="GET">
			<table class="table table-striped" style="margin: 0 auto;width:30%;margin-top:3%;">
				<tr>
					<td colspan="2"><center>Modification du compte N° <%= request.getParameter("Ncompte") %></center></td>
				</tr>
				<tr>
					<td>N°compte :</td>
					<td><input type="text" name="Ncompte" class="form-control" value="<%= request.getParameter("Ncompte") %>" readonly></td>
				</tr> 
				<tr>
					<td>Solde :</td>
					<td><input type="text" name="Solde" class="form-control" value="<%= request.getParameter("Solde") %>" ></td>
				</tr>
				<tr>
					<td>Propriétaire :</td>
					<td><input type="text" name="Proprietaire" class="form-control"  value="<%= request.getParameter("Proprietaire") %>"></td>
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
		<center><a href='consultation.jsp' > Retourné vers la page précédente</center></a>
</body>
</html>