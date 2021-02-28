

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
		String vcompte = request.getParameter("Ncompte"); // le numéro de comtpe à supprimer recue via URL
		// pour récupréer la variable via URL il suffit d'utiliser getParameter() comme pour les récupérer via formulaire
		PrintWriter out = response.getWriter();
		String driver = "com.mysql.jdbc.Driver"; // déclaration d'une variable qui contient le driver JDBC
		String con = "jdbc:mysql://localhost:3308/banque"; // déclaration de la connexion de BD
		String req = "DELETE from comptes where  Ncompte = ?"; // la requete à éxécuté , les ? dans values(?,?) siginie que chaque ? spécifie une colone 
		try {
				Class.forName(driver); // pour charger le driver en mémoire en utilisant la méthode statique forName() de la classe : Class
				Connection conn=DriverManager.getConnection(con, "root" ,""); // déclaration d'un objet Connection qui permet d'établir la connexion BD
				PreparedStatement st=conn.prepareStatement(req);// déclaration de d'un objet PreparedStatement pour éxécuté la requete
				// l'insertion de données 
				//les index pour BD il commence de 1 et non pas de 0 
				//setLong(index,parametre)
				st.setDouble(1,Double.parseDouble(vcompte)); // on a ajoute à la 1 er colonne(solde ) déclarer dans values(?,?) avec setter de type Long
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
