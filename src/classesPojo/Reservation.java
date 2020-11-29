package classesPojo;

import dao.AbstractDAOFactory;
import dao.DAO;

public class Reservation {
	private int id;
	private double accompte;
	private double prix;
	private double solde;
	private String statut;
	private int idplansalle;
	private int idpers;
	private PlaningSalle planingsalle;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Reservation> resdao = adf.getres();
	
	public Reservation() {}
	public Reservation(double a, double p,double s,String st,int ips,int ip) {
		accompte=a;
		prix=p;
		solde=s;
		statut=st;
		idplansalle=ips;
		idpers=ip;
	}
	public double geta() {
		return accompte;
	}
	public double getp() {
		return prix;
	}
	public double gets() {
		return solde;
	}
	public double getips() {
		return idplansalle;
	}
	public String getsta() {
		return statut;
	}
	public double getip() {
		return idpers;
	}
	public void ajout_reservation(double a,String st,int ips,int ip,int nbr_jour) {
		if(st.equals("vendredi") |st.equals("samedi")) {
			double p=4500*nbr_jour;
			this.prix=p;
			double s=p-a;
			Reservation res=new Reservation(a, p, s,st,ips,ip);
			resdao.create(res);
		}
		else {
			double p=3000;
			double s=p-a;
			Reservation res=new Reservation(a, p, s,st,ips,ip);
			resdao.create(res);
		}				
	}
	public String calcul_prix(double p,double a) {
		double s=p-a;
		return "pour un prix de "+ p+ " et vous avez versé "+a+" il reste donc "+s+" à payer";
	}
}
