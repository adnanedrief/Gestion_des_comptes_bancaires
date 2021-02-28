<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification des informations du compte </title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
		<%
				String vcompte = request.getParameter("Ncompte"); // récupérer le Ncompte à partir du URL
				Double vsld=0.0;
				String vprop="";
				// une requete sql pour extraire le solde et propriétaire à partir du Ncompte
				String driver = "com.mysql.jdbc.Driver";
				String con = "jdbc:mysql://localhost:3308/banque";
				String req = "select * from comptes where Ncompte >= ?";
				try {
					Class.forName(driver);
					Connection conn=DriverManager.getConnection(con, "root" ,"");
					PreparedStatement st=conn.prepareStatement(req); // création de l'objet qui va exécuter notre requete
				//	setLong(index,parametre)
					st.setInt(1,Integer.parseInt(vcompte)); 
					ResultSet res=st.executeQuery();
					if(res.next()== true){
					// il ne faut oublié de faire le teste sur ResultSet avant d'extraire les infos sinon on aura cette ERREU : Before start of result set
						vsld=res.getDouble(2);
						vprop=res.getString(3);
						
					}
					
				}
				catch(Exception e){ 
					System.out.println(e.getMessage());
				}
		%>
		
		<form action="Modification2" method="GET">
			<table class="table table-striped" style="margin: 0 auto;width:30%;margin-top:3%;">
				<tr>
					<td colspan="2"><center>Modification du compte N° <%= vcompte %></center></td>
				</tr>
				<tr>
					<td>N°compte :</td>
					<td><input type="text" name="Ncompte" class="form-control"   value="<%= vcompte %>" readonly></td>
				</tr> 
				<tr>
					<td>Solde :</td>
					<td><input type="text" name="Solde" class="form-control" value="<%= vsld %>" ></td>
				</tr>
				<tr>
					<td>Propriétaire :</td>
					<td><input type="text" name="Proprietaire" class="form-control"  value="<%= vprop %>"></td>
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