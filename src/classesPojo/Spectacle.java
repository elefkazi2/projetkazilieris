package classesPojo;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.DAO;


public class Spectacle {
	
	private int id;
	private String titre;
	private int nbreplaceparclient;
	private Set<Representation> listrepresentation;//= new HashSet<>();
	//private Set<Artiste> listartiste = new HashSet<>();
	private configuration config;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Spectacle> sdao =adf.gets();
	
	public Spectacle(int id, String t, int n/*,configuration c*/) {
		this.id = id;
		titre = t;
		nbreplaceparclient = n;
		//config=c;
		listrepresentation = new HashSet<>();
	}

	public Spectacle(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gettitr() {
		return titre;
	}

	public void settitre(String t) {
		this.titre = t;
	}

	public int getnbrplace() {
		return nbreplaceparclient;
	}

	public void setnplace(int n) {
		this.nbreplaceparclient = n;
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
