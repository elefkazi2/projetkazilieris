package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classesPojo.*;

public class SpectacleDao extends DAO<Spectacle>{

	public SpectacleDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Spectacle obj) {
		try{
			String insertion = "INSERT INTO spectacle(titre,nbreplaceparclient,artiste,idplaning) "
					+ "values ('"+obj.gettitr()+"','" + obj.getnpc()+ "','" + obj.getart()+ "','"+obj.getIdplan()+"')";
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
	public boolean delete(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Spectacle obj, String s,String idrep) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int find() {
		int g=0;
		try{
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM spectacle ");
			if(result.last()) {	
				g=result.getInt("idspectacle");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return g;
	}
	@Override
	public List<String> find(String n, String p) {
		List<String> listA = new ArrayList<>();
		int r = 0;
		try{
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM spectacle WHERE titre = '" +n+"' ");//and datedebutr ='"+p+"'");
			if(result.first()) {	
				r=result.getInt("idspectacle");
				String f=String.valueOf(r);
				listA.add(f);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listA;
	}

	@Override
	public Spectacle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
