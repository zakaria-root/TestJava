

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class Servlet
 */

public class AjouterEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GestionEtudiant ge;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	ge = new GestionEtudiant();
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int age = Integer.parseInt(request.getParameter("age")); 
		
		PrintWriter out ;
		Etudiant u =null;

		
		if(lname != null && fname != null)
		{		u = new Etudiant(fname,lname,age);
				ge.ajouterEtudiant(u);
				out = response.getWriter();
				out.println("<!DOCTYPE html>\n"
						+ "<html>\n"
						+ "<head>\n"
						+ "<meta charset=\"UTF-8\">\n"
						+ "<title>Insert title here</title>\n"
						+ "</head>\n<style>\n"
						+ ".button {\n"
						+ "  background-color: #4CAF50;\n"
						+ "  border: none;\n"
						+ "  color: white;\n"
						+ "  padding: 15px 32px;\n"
						+ "  text-align: center;\n"
						+ "  text-decoration: none;\n"
						+ "  display: inline-block;\n"
						+ "  font-size: 16px;\n"
						+ "  margin: 4px 2px;\n"
						+ "  cursor: pointer;\n"
						+ "}"
						+ "#customers {\n"
						+ "  font-family: Arial, Helvetica, sans-serif;\n"
						+ "  border-collapse: collapse;\n"
						+ "  width: 100%;\n"
						+ "}\n"
						+ "\n"
						+ "#customers td, #customers th {\n"
						+ "  border: 1px solid #ddd;\n"
						+ "  padding: 8px;\n"
						+ "}\n"
						+ "\n"
						+ "#customers tr:nth-child(even){background-color: #f2f2f2;}\n"
						+ "\n"
						+ "#customers tr:hover {background-color: #ddd;}\n"
						+ "\n"
						+ "#customers th {\n"
						+ "  padding-top: 12px;\n"
						+ "  padding-bottom: 12px;\n"
						+ "  text-align: left;\n"
						+ "  background-color: #4CAF50;\n"
						+ "  color: white;\n"
						+ "}\n"
						+ "</style>"
						
						+ "<body>");
				out.println("<h4> l'Utisateur "+fname+" est ajouter avec succee !!</h4>");
				out.print("	<table id=\"customers\" >\n");
					out.print("<tr>\n"
							+ "		<th>Nom</th>\n"
							+ "		<th>Prenom</th>\n"
							+ "		<th>Age</th>\n"
							+ "		</tr>\n"
							+ "		<tr>\n"
							+ "		<td>"+fname+"</td>\n"
							+ "		<td>"+lname+"</td>\n"
							+ "		<td>"+age+"</td>\n"
							+ "		</tr>\n");
				out.println("</table>");
				out.print("<a href=\"index.jsp\" class=\"button\">retourner a la page d'accueil</a>");
				out.print("</body>\n"
						+ "</html>");
	
		}else {
					response.sendError(404,"Erreur de saisire !!");
				}
		
		
	}

}
