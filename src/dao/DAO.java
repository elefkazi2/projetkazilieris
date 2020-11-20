package dao;

import java.sql.*;
import java.util.List;


public abstract class DAO<T> {
protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj,String s);
	
	public abstract List<String> find(String n,String p);
	
	public abstract T find(int id);
	
	public abstract int find();

}
