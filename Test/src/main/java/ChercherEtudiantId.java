

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FoundEtudiant
 */

public class ChercherEtudiantId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GestionEtudiant ge;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChercherEtudiantId() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Etudiant u =null;
		PrintWriter out  = response.getWriter();
		String i = request.getParameter("id");
		int id  = Integer.parseInt(i);
			u =new Etudiant();
			u= ge.chercherEtudiant(id);
			if (u != null) {
				HttpSession ss = request.getSession(true);
				ss.setAttribute("id", id);
				response.sendRedirect("infoEtudiant.jsp");
				out.println("<!DOCTYPE html>\n"
						+ "<html>\n"
						+ "<head>\n"
						+ "<meta charset=\"UTF-8\">\n"
						+ "<title>Insert title here</title>\n"
						+ "</head>\n<style>\n"
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
				out.println("voisi les informations de l'itudiant de Id: " +id );
				out.println("testest");
				out.print("		<table id=\"customers\" >\n"
						+ "		<tr>\n"
						+ "		<th>Id</th>\n"
						+ "		<th>Nom</th>\n"
						+ "		<th>Prenom</th>\n"
						+ "		<th>Age</th>\n"
						+ "		</tr>\n"
						+ "		<tr>\n"
						+ "		<td>"+u.getId()+"</td>\n"
						+ "		<td>"+u.getFname()+"</td>\n"
						+ "		<td>"+u.getLname()+"</td>\n"
						+ "		<td>"+u.getAge()+"</td>\n"
						+ "		</tr>\n"
						+ "		</table>");
				
				out.print("</body>\n"
						+ "</html>");
			}else {
				out.print("ce id "+id+" n'exist pas dans la base!! ");
			}

		
	}

}
