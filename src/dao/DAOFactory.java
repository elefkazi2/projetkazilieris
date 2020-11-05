package dao;

import java.sql.Connection;

import classesPojo.*;

public class DAOFactory extends AbstractDAOFactory{
protected static final Connection conn = connexion.connection.getInstance();
	
	public DAO<Personne> getp(){
		return new PersonDao(conn);
	}

}
