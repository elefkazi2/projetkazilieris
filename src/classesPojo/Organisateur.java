package classesPojo;

import java.util.ArrayList;
import java.util.List;

public class Organisateur extends Personne {
	
	private List<Reservation> listereservation= new ArrayList<>();
	
	public Organisateur() {}
	public Organisateur(String nu,String n,String pr,String ad,String pa,String r) {
		super(nu,n,pr,ad,pa,r);
	}
}
