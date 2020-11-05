package classesPojo;

import Frame.*;
import dao.*;

public class Personne {
	
	private int id;
	private String nom_utilisateur;
	private String nom;
	private String prenom;	
	private String adresse;
	private String password;
	private String role;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Personne> persondao = adf.getp();
	
	public Personne(int id,String nu,String n,String pr,String ad,String pa,String r) {
		this.id=id;
		nom_utilisateur=nu;
		nom=n;
		prenom=pr;
		adresse=ad;
		password=pa;
		role=r;
	}
	public Personne(String nu,String n,String pr,String ad,String pa,String r) {
		nom=n;
		prenom=pr;
		password=pa;
		adresse=ad;
		nom_utilisateur=nu;
		role=r;
		
	}
	public Personne() {}
	
	public int getid() {
		return id;
	}
	public String getnu() {
		return nom_utilisateur;
	}
	public String getn() {
		return nom;
	}
	public String getpr() {
		return prenom;
	}
	public String getpa() {
		return password;
	}
	public String getr() {
		return role;
	}
	public void setn(String s) {
		nom=s;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String n) {
		adresse=n;
	}
	public void login(String n,String p) {
		switch(persondao.logindao(n,p)) {
		case "client" :
			client c=new client();
			c.setVisible(true);
			connexionouregister i=new connexionouregister();
			i.setVisible(false);
			break;
		case "gestionnaire":
			gestionnaire g=new gestionnaire();
			g.setVisible(true);
			break;
		case "organisateur":
			organisateur o=new organisateur();
			o.setVisible(true);
			break;
		case "artiste":
			artiste a=new artiste();
			a.setVisible(true);
			break;
		}
	}
	public void register(String nu,String n,String pr,String ad,String pa,String r) {
		Personne p=new Personne(nu,n,pr,ad,pa,r);
		persondao.register(p);		
	}
}
