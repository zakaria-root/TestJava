import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestionEtudiant {

	public int ajouterEtudiant(Etudiant u){
		int nb = 0	 ;

			try {
				DBInteraction.connect();
				nb = DBInteraction.edite("insert into users (fname, lname, age) values('"+u.getFname()+"', '"+u.getLname()+"',"+u.getAge()+" )");
				DBInteraction.disconnect();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nb;			 
	}	
	
	public  Etudiant chercherEtudiant(int id) {
		ResultSet rs= null;
		Etudiant u= null;
		try {
			DBInteraction.connect(); 
			rs = DBInteraction.select("select * from users where id ="+id);
		 if (rs.next()) {
			u =new Etudiant();
			u.setId(rs.getInt(1));
			u.setFname(rs.getString(2));
			u.setLname(rs.getString(3));
			u.setAge(rs.getInt(4));
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBInteraction.disconnect();
		
		return u;
	}
	
	public int supprimerEtdiant(int id ) {
		int nb = 0;
		try {
			DBInteraction.connect();
			nb = DBInteraction.edite("delete from users where id="+id);
			DBInteraction.disconnect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nb;
	
	}
	
	public List<Etudiant> toutEtudiants() {
		List<Etudiant> tu = new ArrayList<Etudiant>();
		try {
			DBInteraction.connect();
			String sql = "select * from users";
			ResultSet rs = DBInteraction.select(sql);
			while (rs.next()) {
			 Etudiant u = new Etudiant();
			u.setId(rs.getInt(1));
			u.setFname(rs.getString(2));
			u.setLname(rs.getString(3));
			u.setAge(rs.getInt(4));
			tu.add(u);
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tu;
		
		
	}
	
	
	
	
	
	
}
