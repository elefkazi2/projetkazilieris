package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import classesPojo.*;

public class SpectacleDao extends DAO<Spectacle>{

	public SpectacleDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Spectacle obj, String s) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Spectacle find(int id) {
		Spectacle spec=new Spectacle();
		//Representation rep = new Representation();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT * FROM spectacle "
									+ "LEFT JOIN representation ON spectacle.idspectacle = representation.idspectacle "
														+ "AND representation.idspectacle= '" + id +
						"'");
			if(result.first()){
				spec=new Spectacle(id/*result.getInt("idspectacle")*/,result.getString("titre"),result.getInt("nbreplaceparclient"));
	             result.beforeFirst();
					RepresentationDao r=new RepresentationDao(connect);
					while(result.next())
						spec.addrepresentation(r.find(result.getInt("idrepresentation")));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return spec;
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
