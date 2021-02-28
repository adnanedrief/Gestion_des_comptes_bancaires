

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vprop = request.getParameter("Proprietaire");
		PrintWriter out = response.getWriter();
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3308/banque";
		String req = "select * from comptes where Proprietaire = ?";
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(con, "root" ,"");
			PreparedStatement st=conn.prepareStatement(req); // création de l'objet qui va exécuter notre requete
		//	setLong(index,parametre)
			st.setString(1,vprop); // puisque on a mit un ? dans notre requete donc le 1er paramétre designe le premier ?
			ResultSet res=st.executeQuery(); 
			// puisque on a un SELECT on doit utiliser executeQuery() mais elle retourne un resultat qui doit etre stocker dans un objet de type ResultSet
			out.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">");
			if(res.next()== true) {
			// res.next()== true :  c'est pour tester si le retour de la requete n'est vide 
				out.println("<table class=\"table table-striped table-hover table-bordered \" style=\"margin: 0 auto;width:40%;margin-top:3%;\">");
				out.println("<tr class='table-success'><td>N°compte</td><td>Solde</td><td>Propriétaire</td><tr>");
				do{
					// next() : c'est comme le principe de itérator
					int Ncompte=res.getInt(1); // on récupère appartir de l'objet res de la classe ResultSet le 1 er parametre ( 1 er colone )  de type INT
					double Solde=res.getDouble(2);// on récupère appartir de l'objet res de la classe ResultSet le 2eme parametre ( 2eme colone )  de type DOUBLE
					String Proprietaire=res.getString(3);// on récupère appartir de l'objet res de la classe ResultSet le 3eme parametre ( 3eme colone )  de type String
					out.println("<tr><td>"+Ncompte+"</td><td>"+Solde+"</td><td>"+Proprietaire+"</td><tr>");
				}while(res.next());
				// ici on a mis do while car quand on a fait le 1er test on pointe sur l 1 er ligne et quand on a passé au while et son test on a passer directement à la deuxième ligne et sauter le 1er résutlat de la 1er ligne
			}else {
				out.print("<br><br><br><h3><center>Compte non trouvé</center></3>");
			}
			out.print("</table>");
			out.print("<center><a href='recherche.jsp' > Retourné vers la page précédentes</center></a>");

		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
		}
	}

}
