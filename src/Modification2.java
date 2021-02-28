

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class Modification1
 */
@WebServlet("/Modification2")
public class Modification2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modification2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "com.mysql.jdbc.Driver"; // d�claration d'une variable qui contient le driver JDBC
		String vsld = request.getParameter("Solde");
		String vprop = request.getParameter("Proprietaire");
		String vcompte = request.getParameter("Ncompte");
		String con = "jdbc:mysql://localhost:3308/banque"; // d�claration de la connexion de BD
		String req = "UPDATE comptes SET Solde=? , Proprietaire=? where Ncompte=?"; // la requete � �x�cut� , les ? dans values(?,?) siginie que chaque ? sp�cifie une colone 
		try {
				Class.forName(driver); // pour charger le driver en m�moire en utilisant la m�thode statique forName() de la classe : Class
				Connection conn=DriverManager.getConnection(con, "root" ,""); // d�claration d'un objet Connection qui permet d'�tablir la connexion BD
				PreparedStatement st=conn.prepareStatement(req);// d�claration de d'un objet PreparedStatement pour �x�cut� la requete
				// l'insertion de donn�es 
				//les index pour BD il commence de 1 et non pas de 0 
				//setLong(index,parametre)
				st.setDouble(1,Double.parseDouble(vsld)); 
				st.setString(2,vprop); 
				st.setInt(3,Integer.parseInt(vcompte));
				st.executeUpdate(); 
				// on �x�cute la requete avec la m�thode executeUpdate() qui fermer d'�x�ter notre requete
				// cette dernier concerne : INSERT,UPDATE,DELETE seulement
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
