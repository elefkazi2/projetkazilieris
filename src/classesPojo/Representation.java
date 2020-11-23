package classesPojo;

import java.util.*;

import dao.AbstractDAOFactory;
import dao.DAO;

public class Representation {
	private int id;
	private Date date;
	private String heured;
	private String heuref;
	private int idspect;
	private Spectacle spectacle;	
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Representation> repdao =adf.getr();

	
	public Representation(int id,Date d,String hd,String hf,Spectacle s) {
		this.id=id;
		date=d;
		heured=hd;
		heuref=hf;
		spectacle=s;
	}
	public Representation(Date d,String hd,String hf,int idspect) {
		date=d;
		heured=hd;
		heuref=hf;
		this.idspect=idspect;
	}
	
	public Representation() {}
	
	public int getidr() {
		return id;
	}
	public int getids() {
		return idspect;
	}
	public Date getdater() {
		return date;
	}
	public String getheured() {
		return heured;
	}
	public String getheuref() {
		return heuref;
	}
	public Spectacle getspect() {
		return spectacle;
	}
	public void setspect(Spectacle s) {
		spectacle=s;
	}
	public Representation toute_les_representations(int id) {
		Representation r=repdao.find(id);
		return new Representation(r.id,r.date,r.heured,r.heuref,r.spectacle);
	}
}
