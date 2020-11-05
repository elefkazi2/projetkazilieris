package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import classesPojo.*;

public class PersonDao extends DAO<Personne>{
	
	public PersonDao(Connection conn) {
		super(conn);
	}
	public boolean register(Personne obj) {
		try{
			String insertion = "INSERT INTO person(nom_utilisateur,nom,prenom,adresse,password,role) values ('"+obj.getnu()+"','" + obj.getn()+ "','"+obj.getpr()+"',"
					+"'"+obj.getAdresse()+"','"+obj.getpa()+"','"+obj.getr()+"')";
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(insertion);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(Personne obj) {
		try{
			String supp = "DELETE * FROM person WHERE nom ='" + obj.getn()+ "' and prenom = '"+obj.getpr()+"'";
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(supp);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Personne obj,String s) {		
		try{
			String modif = "UPDATE person SET nom ='"+s+"' "//',"
					/*+ "prenom = '"+obj.getpr()+"', password = '"+obj.getpa()+"'*/ +"WHERE nom='"+obj.getn()+"'";
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(modif);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public String logindao(String n,String p) {
		String r = null;
		try{
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Person WHERE nom_utilisateur = '" +n+"' and password ='"+p+"'");
			if(result.first()) {
				r=result.getString("role");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
