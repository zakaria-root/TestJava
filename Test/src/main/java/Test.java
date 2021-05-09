import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		GestionEtudiant u = new GestionEtudiant();
		
		System.out.println(u.chercherEtudiant(1).toString());
	}

}
