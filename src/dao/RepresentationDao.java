package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import classesPojo.*;

public class RepresentationDao  extends DAO<Representation>{

	public RepresentationDao(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Representation obj, String s,String idrep) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Representation find(int id) {
		Representation rep = new Representation();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(
					"SELECT * FROM spectacle "
			+ "inner join representation ON spectacle.idspectacle = representation.idspectacle "
			+ "where idrepresentation= '" + id +
			"' ORDER BY daterepresentation ASC");
			if(result.first()){				
	rep = new Representation(result.getInt("idrepresentation"),
			result.getDate("daterepresentation"),result.getString("heuredebut"),result.getString("heurefin"),new Spectacle(result.getInt("idspectacle"),result.getString("titre"),result.getInt("nbreplaceparclient")));	
			}		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rep;
	}
	/*@Override
	public Representation find(int id) {
		Representation rep = new Representation();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT * FROM representation WHERE idrepresentation = '" + id+"'");
			if(result.first()){
	rep = new Representation(id,result.getDate("daterepresentation"), result.getString("heuredebut"),
			result.getString("heurefin"),new Spectacle(result.getInt("idspectacle"),result.getString("titre"),result.getInt("nbreplaceparclient"))); 
			}
			
		}
		catch(SQLException e){
			//e.printStackTrace();
		}
		return rep;
	}*/
	
	@Override
	public int find() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> find(String n, String p) {
		// TODO Auto-generated method stub
		return null;
	}
}
