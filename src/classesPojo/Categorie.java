package classesPojo;

import java.util.List;

import dao.AbstractDAOFactory;
import dao.DAO;

public class Categorie {

	private int id;
	private String type;
	private double prix;
	private int nbreplacedispo;
	private int nbreplacemax;
	private int idconf;
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
	public Categorie(String t,double p,int nd,int nm,int ic) {
		type=t;
		prix=p;
		nbreplacedispo=nd;
		nbreplacemax=nm;
		idconf=ic;
	}
	
	public Categorie() {}
	
	public int getidcat() {
		return id;
	}
	public String gettypecat() {
		return type;
	}
	public void settypecat(String h) {
		type=h;
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
	public int getic() {
		return idconf;
	}
	public double getp() {
		return prix;
	}
	public List<String> recup_prix_et_nbreplacedispo(String typecat,String idrep){
		return catdao.find(typecat, idrep);
	}
	public int recup_idconfig(String typecat, String idrep) {
		configuration c=new configuration();	
		Categorie cat=new Categorie();
		c.setcat(cat);
		
		String h=c.getcat().recup_prix_et_nbreplacedispo(typecat, idrep).get(2);
		return Integer.valueOf(h);
	}
	public void decrementer_nbre_place(String typecat,String nbrefinal, String idrep) {
		Categorie c=new Categorie();
		c.settypecat(typecat);
		catdao.update(c, nbrefinal, idrep);
	}
	public void ajout_categorie(String t,double p,int nd,int nm,int ic) {
		Categorie c =new  Categorie(t, p, nd,nm, ic);
		catdao.create(c);		
	}
}
