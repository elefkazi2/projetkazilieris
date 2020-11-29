package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import classesPojo.*;

public class ReservationDao extends DAO<Reservation>{
	
	public ReservationDao(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Reservation obj) {
		try{
			String insertion = "INSERT INTO reservation(accompte,statut,prix,solde,idplaning,id)"
					+ " values ('"+obj.geta()+"','" + obj.getsta()+ "','"+obj.getp()+"',"
					+"'"+obj.gets()+"','"+obj.getips()+"','"+obj.getip()+"')";
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
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj, String s, String idrep) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> find(String n, String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int find() {
		// TODO Auto-generated method stub
		return 0;
	}

}
