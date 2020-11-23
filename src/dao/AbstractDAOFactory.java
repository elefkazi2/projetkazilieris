package dao;


import classesPojo.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Personne> getp();
	public abstract DAO<Representation> getr();
	public abstract DAO<Spectacle> gets();
	public abstract DAO<Place> getplace();
	public abstract DAO<Commande> getc();
	public abstract DAO<Categorie> getcat();
	public abstract DAO<Reservation> getres();
	public abstract DAO<configuration> getconf();
	public abstract DAO<PlaningSalle> getpl();
		
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
}
