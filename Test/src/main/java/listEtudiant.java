

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class listEtudiant
 */
//@WebServlet("/listEtudiant")
public class listEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GestionEtudiant ge;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	ge = new GestionEtudiant();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<Etudiant> tu = ge.toutEtudiants();
		PrintWriter out = response.getWriter();

		if(request.getParameter("op")!=null)
		{
			if(request.getParameter("op").equals("delete"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				ge.supprimerEtdiant(id);
				System.out.println("suppression de l'etudiant a id ="+id);
			}
		}
		
		if(tu != null)
		{
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
				out.println("<h4>voisi le tableau des etudiants </h4>" );
				out.print("		<table id=\"customers\" >\n");
				for (Etudiant u1 : tu) {
					out.print("<tr>\n"
							+ "		<th>Id</th>\n"
							+ "		<th>Nom</th>\n"
							+ "		<th>Prenom</th>\n"
							+ "		<th>Age</th>\n"
							+ "		<th>Action</th>\n"
							+ "		</tr>\n"
							+ "		<tr>\n"
							+ "		<td>"+u1.getId()+"</td>\n"
							+ "		<td>"+u1.getFname()+"</td>\n"
							+ "		<td>"+u1.getLname()+"</td>\n"
							+ "		<td>"+u1.getAge()+"</td>\n"
							+ "		<td><a href='?op=delete&id="+u1.getId()+"'>supprimer</a></td>\n"
							+ "		</tr>\n");
				}
				out.print("</table>");
	
		}else {
					out.println("<h4> aucun etudiant n'y enregistrer dans la base <h4/>");
				}
		out.print("</body>\n"
				+ "</html>");
	}

}
