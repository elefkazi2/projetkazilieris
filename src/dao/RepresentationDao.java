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
		try{
			String insertion = "INSERT INTO representation(daterepresentation,heuredebut,heurefin,idspectacle)"
					+ " values ('"+obj.getdater()+"','" + obj.getheured()+ "','"+obj.getheuref()+"',"
					+"'"+obj.getids()+"')";
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
			+ "inner join representation ON spectacle.idspectacle = representation.idspectacle inner join configuration" 
			+ " on spectacle.idspectacle = configuration.idspectacle where idrepresentation= '" + id +
			"' ORDER BY daterepresentation ASC");
			if(result.first()){				
	rep = new Representation(result.getInt("idrepresentation"),
			result.getString("daterepresentation"),result.getString("heuredebut"),result.getString("heurefin"),new Spectacle(result.getInt("idspectacle"),result.getString("titre"),result.getInt("nbreplaceparclient"),result.getString("artiste"),new configuration(result.getString("type"),result.getInt("idspectacle"),result.getInt("idrepresentation"))));	
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
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM representation ");
			if(result.last()) {	
				g=result.getInt("idrepresentation");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public List<String> find(String n, String p) {
		// TODO Auto-generated method stub
		return null;
	}
}
