package classesPojo;

import java.util.List;

import dao.AbstractDAOFactory;
import dao.DAO;

public class Commande {
	
	private int id;
	private String modelivraison;
	private String modepayement;
	private double cout;
	private int id_cli;
	Place place;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Commande> commandedao =adf.getc();
	
	public Commande() {}
	public Commande(String ml,String mp/*,Place p*/,int ic) {
	
		modelivraison=ml;
		modepayement=mp;
		//place=p;
		id_cli=ic;
	}
	public int getid() {
		return id;
	}
	public String getml() {
		return modelivraison;
	}
	public String getmp() {
		return modepayement;
	}
	public int getidclient() {
		return id_cli;
	}
	public void setidclient(int i) {
		id_cli=i;
	}
	public Place getplacom() {
		return place;
	}
	public void reservation_client(int idc,int nbre_place,String ml,String mp,int idrep) {
		Commande c =new Commande(ml,mp,idc);
		commandedao.create(c);
	}
	public int recup_dernier_comm(){
		return commandedao.find();
	}	
	public double getcout(String typecat, String idrep,int nbreplace) {
		int y=place.getprix(typecat, idrep);		
		return (double) y*nbreplace;
	}
}
