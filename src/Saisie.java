

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
		// ins�rtion dans la base de donn�es
		String driver = "com.mysql.jdbc.Driver"; // d�claration d'une variable qui contient le driver JDBC
		String con = "jdbc:mysql://localhost:3308/banque"; // d�claration de la connexion de BD
		String req = "insert into comptes(Solde, Proprietaire) values(?,?)"; // la requete � �x�cut� , les ? dans values(?,?) siginie que chaque ? sp�cifie une colone 
		try {
				Class.forName(driver); // pour charger le driver en m�moire en utilisant la m�thode statique forName() de la classe : Class
				Connection conn=DriverManager.getConnection(con, "root" ,""); // d�claration d'un objet Connection qui permet d'�tablir la connexion BD
				PreparedStatement st=conn.prepareStatement(req);// d�claration de d'un objet PreparedStatement pour �x�cut� la requete
				// l'insertion de donn�es 
				//les index pour BD il commence de 1 et non pas de 0 
				//setLong(index,parametre)
				st.setDouble(1, Double.parseDouble(vsolde)); // on a ajoute � la 1 er colonne(solde ) d�clarer dans values(?,?) avec setter de type Long
				// setLong(index,paramatre ) : prend comme 1 er parametre l'index du 1er signe : ? qui se trouve dans la requete et le 2eme param�tre est la valeur � ajouter � la place de ? dans la requete 
				st.setString(2, vproprietaire); // on a ajoute � la 2eme colonne ( proprietaire )  d�clarer dans values(?,?) avec setter
				st.executeUpdate(); 
				// on �x�cute la requete avec la m�thode executeUpdate() qui fermer d'�x�ter notre requete
				// cette dernier concerne : INSERT,UPDATE,DELETE seulement
				//
				// apr�s l'insertion on va redireger la page vers consultation.jsp
				response.sendRedirect("consultation.jsp");
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
		}
	}

}
