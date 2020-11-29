package classesPojo;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.DAO;

public class configuration {
	
	private int id;
	private String type;
	private int idspect;
	private int idrep;
	private Categorie categorie;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<configuration> confdao = adf.getconf();
	
	public configuration(String t,int is,int ir) {
		type=t;
		idspect=is;
		idrep=ir;
	}
	public configuration() {}
	
	public int getidconfig() {
		return id;
	}
	public String gettypeconfig() {
		return type;
	}
	public int getrep() {
		return idrep;
	}
	public int getspect() {
		return idspect;
	}
	public int recup_dernier_conf(){
		return confdao.find();
	}
	public void setspect(int s) {
		idspect=s;
	}
	public Categorie getcat(){
		return categorie; 
	}
	public void setcat(Categorie c){
		categorie=c;
	}
	public void ajout_configuration(String t,int is,int ir,int ic) {
		Categorie cat=new Categorie();		
		configuration c =new configuration(t,is,ir);	
		confdao.create(c);	
		c.setcat(cat);
		switch(t) {		
		case "debout":
			c.getcat().ajout_categorie(t, 15, 8000, 8000, ic);
			break;
		case "cirque":
			c.getcat().ajout_categorie("diamant", 60, 1000, 1000, ic);
			c.getcat().ajout_categorie("or", 50, 2000, 2000, ic);
			c.getcat().ajout_categorie("argent", 35, 1500, 1500, ic);
			c.getcat().ajout_categorie("bronze", 20, 1500, 1500, ic);
			break;
		case "concert":
			c.getcat().ajout_categorie("or", 50, 500, 500, ic);
			c.getcat().ajout_categorie("argent", 35, 1500, 1500, ic);
			c.getcat().ajout_categorie("bronze", 20, 3000, 3000, ic);
			break;			
		}		
	}	
}
