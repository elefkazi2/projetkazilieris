package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classesPojo.*;

public class PersonDao extends DAO<Personne>{
	
	public PersonDao(Connection conn) {
		super(conn);
	}
	public boolean create(Personne obj) {
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
	public List<String> find(String n,String p) {
	List<String> listA = new ArrayList<>();
		String r = null;
		int g=0;
		try{
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Person WHERE nom_utilisateur = '" +n+"' and password ='"+p+"'");
			if(result.first()) {	
				r=result.getString("role");
				g=result.getInt("id");
				String d=String.valueOf(g);
			  listA.add(r);
			  listA.add(d);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listA;
	}
	@Override
	public Personne find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int find() {
		// TODO Auto-generated method stub
		return 0;
	}

}
