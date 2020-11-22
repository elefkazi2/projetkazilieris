package classesPojo;

import java.util.HashSet;
import java.util.Set;

public class Client extends Personne{
	
	private Set<Commande> listcommande =new HashSet<>();
	
	public Client() {}
	public Client(String nu,String n,String pr,String ad,String pa,String r) {
		super(nu,n,pr,ad,pa,r);
	}
	public void register(String nu,String n,String pr,String ad,String pa) {
		super.register(nu, n, pr,ad, pa, "client");		
	}
	public  Set<Commande> getcomm(){
		return listcommande;
	}
}
