package dao;

import java.sql.Connection;

import classesPojo.*;

public class DAOFactory extends AbstractDAOFactory{
protected static final Connection conn = connexion.connection.getInstance();
	
	public DAO<Personne> getp(){
		return new PersonDao(conn);
	}
	
	public DAO<Representation> getr(){
		return new RepresentationDao(conn);
	}
	public DAO<Spectacle> gets(){
		return new SpectacleDao(conn);
	}
	public DAO<Place> getplace(){
		return new PlaceDao(conn);
	}
	public DAO<Commande> getc(){
		return new CommandeDao(conn);
	}
	public DAO<Categorie> getcat(){
		return new CategorieDao(conn);
	}
	public DAO<Reservation> getres() {
		return new ReservationDao(conn);
	}
	public DAO<configuration> getconf() {
		return new configurationDao(conn);
	}
	public DAO<PlaningSalle> getpl() {
		return new PlaningSalleDao(conn);
	}
}
