

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Saisie
 */
@WebServlet("/Saisie")
public class Saisie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saisie() {
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
		String vsolde = request.getParameter("Solde");
		String vproprietaire = request.getParameter("Proprietaire");
		// insértion dans la base de données
		String driver = "com.mysql.jdbc.Driver"; // déclaration d'une variable qui contient le driver JDBC
		String con = "jdbc:mysql://localhost:3308/banque"; // déclaration de la connexion de BD
		String req = "insert into comptes(Solde, Proprietaire) values(?,?)"; // la requete à éxécuté , les ? dans values(?,?) siginie que chaque ? spécifie une colone 
		try {
				Class.forName(driver); // pour charger le driver en mémoire en utilisant la méthode statique forName() de la classe : Class
				Connection conn=DriverManager.getConnection(con, "root" ,""); // déclaration d'un objet Connection qui permet d'établir la connexion BD
				PreparedStatement st=conn.prepareStatement(req);// déclaration de d'un objet PreparedStatement pour éxécuté la requete
				// l'insertion de données 
				//les index pour BD il commence de 1 et non pas de 0 
				//setLong(index,parametre)
				st.setDouble(1, Double.parseDouble(vsolde)); // on a ajoute à la 1 er colonne(solde ) déclarer dans values(?,?) avec setter de type Long
				// setLong(index,paramatre ) : prend comme 1 er parametre l'index du 1er signe : ? qui se trouve dans la requete et le 2eme paramètre est la valeur à ajouter à la place de ? dans la requete 
				st.setString(2, vproprietaire); // on a ajoute à la 2eme colonne ( proprietaire )  déclarer dans values(?,?) avec setter
				st.executeUpdate(); 
				// on éxécute la requete avec la méthode executeUpdate() qui fermer d'éxéter notre requete
				// cette dernier concerne : INSERT,UPDATE,DELETE seulement
				//
				// après l'insertion on va redireger la page vers consultation.jsp
				response.sendRedirect("consultation.jsp");
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
		}
	}

}
