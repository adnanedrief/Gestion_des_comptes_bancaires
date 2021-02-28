

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import java.sql.*;
/**
 * Servlet implementation class Supprimer
 */
@WebServlet("/Supprimer")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vcompte = request.getParameter("Ncompte"); // le num�ro de comtpe � supprimer recue via URL
		// pour r�cupr�er la variable via URL il suffit d'utiliser getParameter() comme pour les r�cup�rer via formulaire
		PrintWriter out = response.getWriter();
		String driver = "com.mysql.jdbc.Driver"; // d�claration d'une variable qui contient le driver JDBC
		String con = "jdbc:mysql://localhost:3308/banque"; // d�claration de la connexion de BD
		String req = "DELETE from comptes where  Ncompte = ?"; // la requete � �x�cut� , les ? dans values(?,?) siginie que chaque ? sp�cifie une colone 
		try {
				Class.forName(driver); // pour charger le driver en m�moire en utilisant la m�thode statique forName() de la classe : Class
				Connection conn=DriverManager.getConnection(con, "root" ,""); // d�claration d'un objet Connection qui permet d'�tablir la connexion BD
				PreparedStatement st=conn.prepareStatement(req);// d�claration de d'un objet PreparedStatement pour �x�cut� la requete
				// l'insertion de donn�es 
				//les index pour BD il commence de 1 et non pas de 0 
				//setLong(index,parametre)
				st.setDouble(1,Double.parseDouble(vcompte)); // on a ajoute � la 1 er colonne(solde ) d�clarer dans values(?,?) avec setter de type Long
				st.executeUpdate(); 
				response.sendRedirect("consultation.jsp");
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
