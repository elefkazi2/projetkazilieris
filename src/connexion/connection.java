package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class connection {
private static Connection instance = null;//donc le static
	
	private connection(){//donc constr prive
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://./Projet.accdb";
			instance = DriverManager.getConnection(url);//mon uniqeu instance donc la le singleton
		}
		catch(ClassNotFoundException ex){
	JOptionPane.showMessageDialog(null, "Classe de driver introuvable" + ex.getMessage());
			System.exit(0);
		}
		catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, "Erreur JDBC : " + ex.getMessage());
		}
		if (instance == null) {
            JOptionPane.showMessageDialog(null, "La base de données est inaccessible, fermeture du programme.");
            System.exit(0);
        }
	}
	public static Connection getInstance() {//methode pour retourner mon unique instance
		if(instance == null){
			new connection();
		}
		return instance;
	}
}
