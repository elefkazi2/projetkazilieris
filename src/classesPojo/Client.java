package classesPojo;
public class Client extends Personne{
	
	private int nbre_com;
	Commande tab_commande[];
	
	public Client() {}
	/*public Client(String n,String p,String a,int nbr_commax) {
		super(n,p,a);
		nbre_com=0;
		tab_commande=new Commande[nbr_commax];
	}*/
	public Client(String nu,String n,String pr,String ad,String pa,String r) {
		super(nu,n,pr,ad,pa,r);
	}
	public void register(String nu,String n,String pr,String ad,String pa) {
		super.register(nu, n, pr,ad, pa, "client");		
	}
	public void passercommandeclient(Commande c) {
		if(nbre_com<tab_commande.length) {
			tab_commande[nbre_com++]=c;
		}
		else 
		{
			System.out.println("trop de commande");
		}		
	}
	public void afficherclient() {
		if(nbre_com!=0) {				
			System.out.println(super.toString());
			for(int i=0;i<tab_commande.length;i++) {
				System.out.println(tab_commande[i]);
			}
		}
	}
}
