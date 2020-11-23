package classesPojo;

public class Reservation {
	private int id;
	private double accompte;
	private double prix;
	private double solde;
	private String statut;
	private int idplansalle;
	private int idpers;
	
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
}
