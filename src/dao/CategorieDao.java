package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classesPojo.*;

public class CategorieDao extends DAO<Categorie>{
	
	public CategorieDao(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Categorie obj) {
		try{
			String insertion = "INSERT INTO categorie(type,prix,nbrplacedispo,nbrplacemax,idconfig) "
					+ "values ('"+obj.gettypecat()+"','" + obj.getp()+ "','"+obj.getdispo()+"',"
					+"'"+obj.getmaxt()+"','"+obj.getic()+"')";
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
	public boolean delete(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie obj, String s,String idrep) {
		try{
			String modif = "UPDATE categorie SET nbrplacedispo ='"+s+"' " +"WHERE type='"+obj.gettypecat()+"'"
					+ " and idconfig='"+obj.recup_idconfig(obj.gettypecat(), idrep)+"'";
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(modif);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<String> find(String n, String p) {
		List<String> listA = new ArrayList<>();
		int r = 0;
		int g=0;
		int h=0;
		try{
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM categorie inner join configuration on categorie.idconfig=configuration.idconfig WHERE categorie.type = '" +n+"' and idrepresentation ='"+p+"'");
			if(result.first()) {	
				r=result.getInt("nbrplacedispo");
				String f=String.valueOf(r);
				g=result.getInt("prix");
				String d=String.valueOf(g);
				h=result.getInt("categorie.idconfig");
				String t=String.valueOf(h);
			  listA.add(f);
			  listA.add(d);
			  listA.add(t);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listA;
	}
	@Override
	public Categorie find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int find() {
		// TODO Auto-generated method stub
		return 0;
	}
}
