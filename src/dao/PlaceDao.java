package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import classesPojo.*;

public class PlaceDao extends DAO<Place>{

	public PlaceDao(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Place obj) {
		//int i=0;
		try{
			//ResultSet req;
			//req = this.connect.createStatement().executeQuery("SELECT count(*) as nbre FROM commande");
			
			//while(req.next()) {	
				//i=req.getInt("nbre");		
			String insertion = "INSERT INTO place(Refcommande,idrepresentation) values ('"+obj.getrefcommplace()/*i+1*/ +"','" + obj.getidrepplace()+ "')";
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
	public boolean delete(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj, String s,String idrep) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Place find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

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
