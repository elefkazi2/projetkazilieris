package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classesPojo.*;

public class CommandeDao extends DAO<Commande>{

	public CommandeDao(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Commande obj) {
		try{
			String insertion = "INSERT INTO commande(modepayement,modelivraison,id) values ('"+obj.getmp()+"','" + obj.getml()+ "','"+obj.getidclient()+"')";
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(insertion);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj, String s) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Commande find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int find() {
		int g=0;
		try{
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM commande ");
			if(result.last()) {	
				g=result.getInt("Refcommande");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public List<String> find(String n, String p) {
			return null;
	}

}
