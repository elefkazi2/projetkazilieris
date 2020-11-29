package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import classesPojo.*;

public class configurationDao extends DAO<configuration>{
	
	public configurationDao(Connection conn) {
		super(conn);
	}
	public boolean create(configuration obj) {
		try{
			String insertion = "INSERT INTO configuration(type,idspectacle,idrepresentation) "
					+ "values ('"+obj.gettypeconfig()+"','" + obj.getspect()+ "','"+obj.getrep()+"')";
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
	public boolean delete(configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(configuration obj, String s, String idrep) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<String> find(String n, String p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public configuration find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int find() {
		int g=0;
		try{
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM configuration ");
			if(result.last()) {	
				g=result.getInt("idconfig");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return g;
	}

}
