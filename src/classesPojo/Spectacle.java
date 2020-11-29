package classesPojo;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.DAO;


public class Spectacle {
	
	private int id;
	private String titre;
	private String artiste;
	private int nbreplaceparclient;
	private int idplaning;
	private List<Representation> listrepresentation = new ArrayList<>();
	private configuration config;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Spectacle> sdao =adf.gets();

	public Spectacle(int id, String t,int npc,String artiste,configuration c) {
		this.id = id;
		titre = t;
		nbreplaceparclient=npc;
		this.artiste=artiste;
		config=c;
	}
	public Spectacle(String t,String a,int npc,int idplaning) {
		titre=t;
		artiste=a;
		nbreplaceparclient=npc;
		this.idplaning=idplaning;
	}
	public Spectacle(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getnpc() {
		return nbreplaceparclient;
	}

	public String gettitr() {
		return titre;
	}
	public void settitre(String t) {
		this.titre = t;
	}
	public String getart() {
		return artiste;
	}
	public void setart(String n) {
		this.artiste = n;
	}
	public int getIdplan() {
		return idplaning;
	}
	public int recup_dernier_spec(){
		return sdao.find();
	}
	public void setIdplan(int id) {
		this.idplaning = id;
	}
	public configuration getconfig() {
		return config;
	}
	public void setconfig(configuration c) {
		config=c;
	}
	public List<String> recup_id(String titre,String d){
		return sdao.find(titre, d);
	}
	public List<Representation> getListrepresentation() {
		return listrepresentation;
	}
	public void setListrepresentation(List<Representation> listrepresentation) {
		this.listrepresentation= listrepresentation;
	}
	public void ajout_spectacle(String t,String a,int idplaning) {
		Spectacle s=new Spectacle(t,a,10,idplaning);
		sdao.create(s);		
	}	
}
