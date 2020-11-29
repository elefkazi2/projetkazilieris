package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import classesPojo.*;

public class PlaningSalleDao extends DAO<PlaningSalle>{
	
	public PlaningSalleDao(Connection conn) {
		super(conn);
	}
	public boolean create(PlaningSalle obj) {
		try{
			String insertion = "INSERT INTO planingsalle(datedebutr,datefinr,id)"
					+ " values ('"+obj.getdd()+"','" + obj.getdf()+ "','"+obj.getidpers()+"')";
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
	public boolean delete(PlaningSalle obj) {
		return false;
	}
	@Override
	public boolean update(PlaningSalle obj, String s, String idrep) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<String> find(String n, String p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PlaningSalle find(int id) {
		PlaningSalle rep = new PlaningSalle();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(
					"SELECT * FROM spectacle "
			+ "inner join planingsalle ON spectacle.idplaning = planingsalle.idplaning inner join configuration"
			+ " on spectacle.idspectacle = configuration.idspectacle "
			+ "where idplaning= '" + id +
			"'");
			if(result.first()){				
	rep = new PlaningSalle(result.getInt("idplaning"),
			result.getString("datedebutr"),result.getString("datefinr"),new Spectacle(result.getInt("idspectacle"),result.getString("titre"),result.getInt("nbreplaceparclient"),result.getString("artiste"),new configuration(result.getString("type"),result.getInt("idspectacle"),result.getInt("idrepresentation"))));	
			}		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rep;
	}
	@Override
	public int find() {
		int g=0;
		try{
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM planingsalle ");
			if(result.last()) {	
				g=result.getInt("idplaning");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return g;
	}
}
