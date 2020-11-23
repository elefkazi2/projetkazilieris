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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int find() {
		// TODO Auto-generated method stub
		return 0;
	}

}
