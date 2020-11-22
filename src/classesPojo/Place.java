package classesPojo;

import dao.AbstractDAOFactory;
import dao.DAO;

public class Place {
	
	private int id;
	private int ref_commande;
	private int id_rep;
	private Representation representation; 
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Place> placedao =adf.getplace();
	
	public Place(int rc,int idrep) {
		ref_commande=rc;
		this.id_rep=idrep;
	}
	public Place() {}
	public int getPlacenum() {
		return id;
	}
	public int getidrepplace() {
		return  id_rep;
	}
	public int getrefcommplace() {
		return ref_commande;
	}
	public Representation getrepplace() {
		return representation;
	}
	public int prix(String typecat, String idrep) {
		Representation r=new Representation();
		Spectacle s=new Spectacle();
		configuration c=new configuration();	
		Categorie cat=new Categorie();
		r.setspect(s);
		r.getspect().setconfig(c);
		r.getspect().getconfig().setcat(cat);
		
		String h=r.getspect().getconfig().getcat().recup_prix_et_nbreplacedispo(typecat, idrep).get(1);
		return Integer.valueOf(h);
	}
	public void creation_place(int refcomm, int idrep, int nbre_place) {
		for(int i=0;i<nbre_place;i++) {
		Place c =new Place(refcomm,idrep);
		placedao.create(c);
		}
	}
	public int nbre_place_encore_dispo(String typecat, String idrep) {
		Representation r=new Representation();
		Spectacle s=new Spectacle();
		configuration c=new configuration();	
		Categorie cat=new Categorie();
		r.setspect(s);
		r.getspect().setconfig(c);
		r.getspect().getconfig().setcat(cat);
		
		String h=r.getspect().getconfig().getcat().recup_prix_et_nbreplacedispo(typecat, idrep).get(0);
		return Integer.valueOf(h);
	}
}
