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
	private Set<Representation> listrepresentation;
	//private Set<Artiste> listartiste = new HashSet<>();
	private configuration config;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Spectacle> sdao =adf.gets();
	
	public Spectacle(int id, String t,int npc/*,configuration c*/) {
		this.id = id;
		titre = t;
		nbreplaceparclient=npc;
		//config=c;
		listrepresentation = new HashSet<>();
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

	public void setIdplan(int id) {
		this.idplaning = id;
	}
	public configuration getconfig() {
		return config;
	}
	public void setconfig(configuration c) {
		config=c;
	}

	public Set<Representation> getListrepresentation() {
		return listrepresentation;
	}

	public void setListrepresentation(Set<Representation> listrepresentation) {
		this.listrepresentation= listrepresentation;
	}
	public void addrepresentation(Representation r){
		this.listrepresentation.add(r);
	}
	/*public void tout_les_spectacles(int id) {
		Spectacle r=sdao.find(id);
		this.id=r.id;
		this.titre=r.titre;
		this.nbreplaceparclient=r.nbreplaceparclient;
		setListrepresentation(r.listrepresentation);
	}*/
	/*public void removeMatiere(Matiere matiere){
		this.listMatiere.remove(matiere);
	}*/

}
