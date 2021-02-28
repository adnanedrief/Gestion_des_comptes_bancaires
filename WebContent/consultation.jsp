<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
 	String username = (String)session.getAttribute("login");
 	if(username == null){
		response.sendRedirect("index.jsp");
	}
 		
 %>
<%@ include file="menu.jsp" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultation des comptes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
		<table class="table table-striped table-hover table-bordered " style="margin: 0 auto;width:70%;margin-top:3%;">
		<tr>
			<td colspan="4"><center>Consultation des comptes</center></td>
		</tr>
			<% 
			// le code java à intérieur de la page JSP pour faire la lecture à partir de la Base de données
				String driver = "com.mysql.jdbc.Driver";
				String con = "jdbc:mysql://localhost:3308/banque";
				String req = "select * from comptes ";
				try {
				Class.forName(driver);
				Connection conn=DriverManager.getConnection(con, "root" ,"");
				PreparedStatement st=conn.prepareStatement(req); // création de l'objet qui va exécuter notre requete
				ResultSet res=st.executeQuery(); 
				// puisque on a un SELECT on doit utiliser executeQuery() mais elle retourne un resultat qui doit etre stocker dans un objet de type ResultSet
				out.println("<tr class='table-success'><td>N°compte</td><td>Solde</td><td>Propriétaire</td><td><center>Action</center></td><tr>");
				while(res.next()){
						// next() : c'est comme le principe de itérator
						int Ncompte=res.getInt(1); // on récupère appartir de l'objet res de la classe ResultSet le 1 er parametre ( 1 er colone )  de type INT
						double Solde=res.getDouble(2);// on récupère appartir de l'objet res de la classe ResultSet le 2eme parametre ( 2eme colone )  de type DOUBLE
						String Proprietaire=res.getString(3);// on récupère appartir de l'objet res de la classe ResultSet le 3eme parametre ( 3eme colone )  de type String
						out.println("<tr><td>"+Ncompte+"</td><td>"+Solde+"</td><td>"+Proprietaire+"</td>");
						out.println("<td><a href=\"modification1.jsp?Ncompte=" + Ncompte + "&Solde= "+ Solde+ "&Proprietaire="+Proprietaire+"\" class=\"btn btn-primary\"> Modification( méthode 1 )</a>");
						out.println("<a href=\"Supprimer?Ncompte=" + Ncompte + "\" class=\"btn btn-danger\" > Supprimer</a>");
						out.println("<a href=\"modification2.jsp?Ncompte=" + Ncompte + "\" class=\"btn btn-primary\"> Modification( méthode 2 )</a></td></tr>");
					}
				}
				catch(Exception e){ 
					System.out.println(e.getMessage());
				}
					
			%>	
		</table>
</body>
</html>