package classesPojo;

import java.util.List;

import dao.AbstractDAOFactory;
import dao.DAO;

public class Categorie {

	private int id;
	private String type;
	private int nbreplacedispo;
	private int nbreplacemax;
	private configuration conf;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Categorie> catdao = adf.getcat();
	
	public Categorie(int i,String t,int nd,int nm,configuration c) {
		id=i;
		type=t;
		nbreplacedispo=nd;
		nbreplacemax=nm;
		conf=c;
	}
	
	public Categorie() {}
	
	public int getidcat() {
		return id;
	}
	public String gettypecat() {
		return type;
	}
	public configuration getconf() {
		return conf;
	}
	public int getdispo() {
		return nbreplacedispo;
	}
	public int getmaxt() {
		return nbreplacemax;
	}
	public List<String> recup_prix_et_nbreplacedispo(String typecat,String idrep){
		return catdao.find(typecat, idrep);
	}
}
