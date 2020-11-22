package classesPojo;

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
	public Commande(String ml,String mp,double cout,int ic) {
	
		modelivraison=ml;
		modepayement=mp;
		//place=p;
		this.cout=cout;
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
	public double getcoutbon() {
		return cout;
	}
	public Place getplacom() {
		return place;
	}
	public void reservation_client(int idc,int nbre_place,String ml,String mp,int idrep,String typecat) {
		if(mp.equals("par envoi securisé(+10€)")) {
			double t=cout(typecat,String.valueOf(idrep),nbre_place)+10;
			Commande c =new Commande(ml,mp,t,idc);
			commandedao.create(c);
		}
		else {
			Commande c =new Commande(ml,mp,cout(typecat,String.valueOf(idrep),nbre_place),idc);
			commandedao.create(c);
		}
	}
	public int recup_dernier_comm(){
		return commandedao.find();
	}	
	public double cout(String typecat, String idrep,int nbreplace) {
		Place p=new Place();
		int y=p.prix(typecat, idrep);		
		return (double) y*nbreplace;
	}
}
