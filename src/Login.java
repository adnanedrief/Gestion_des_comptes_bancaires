

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String vlogin = request.getParameter("login");
		String vpwd = request.getParameter("pwd");
		// on va tester si le login appartient à la base de données ou non 
		HttpSession session = request.getSession(); 		// création de objet session où on va stocker le login s'il est juste
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3308/banque";
		String req = "select * from users where login = ? and password = ?";
		try {
				Class.forName(driver);
				Connection conn=DriverManager.getConnection(con, "root" ,"");
				PreparedStatement st=conn.prepareStatement(req); // création de l'objet qui va exécuter notre requete
			//	setLong(index,parametre)
				st.setString(1,vlogin); // puisque on a mit un ? dans notre requete donc le 1er paramétre designe le premier ?
				st.setString(2,vpwd);
				ResultSet res=st.executeQuery(); 
				// puisque on a un SELECT on doit utiliser executeQuery() mais elle retourne un resultat qui doit etre stocker dans un objet de type ResultSet
				if(res.next() == true) {
						// res.next()== true :  c'est pour tester si le retour de la requete n'est vide
					session.setAttribute("login",vlogin);// stocker dans l'objet session la valeur vlogin dans la variable (login) pour tester dans les autres pages si utilisateur à enter le login pour accéder au autre page
					response.sendRedirect("consultation.jsp");
				}
				else { //res.next() == false
						session.setAttribute("login",null);
						response.sendRedirect("index.jsp");
				}
			}
		catch(Exception e){ 
			System.out.println(e.getMessage());
		}
		
		
	}

}
