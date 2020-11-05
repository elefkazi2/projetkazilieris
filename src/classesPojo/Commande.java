package classesPojo;

public class Commande {
	
	private String modelivraison;
	private String modepayement;
	//a retourner voir dans le diagdeclasse pour rajouter cout car je sais pas encore comment le mettre
	Place place;
	
	public Commande() {}
	public Commande(String ml,String mp,Place p) {
	
		modelivraison=ml;
		modepayement=mp;
		place=p;
	}
	@Override
	public String toString() {
		if(place.getPlacenomb()>place.getPlaceMax()) {
			return "vous ne pouvez pas prendre autant de places ";
		}
		return "il a passé comme commande avec un mode livraison : "+modelivraison+" et un mode payement : "+modepayement+" "+place;
		//en mettant place la ca reprend le tostring de sa classe car je l ai instancie dans le main
	}	
}
