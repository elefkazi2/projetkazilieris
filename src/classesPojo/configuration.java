package classesPojo;

import java.util.*;

public class configuration {
	
	private int id;
	private String type;
	private Spectacle spectacle;
	private Representation rep;
	private Categorie categorie;
	//private Set<Categorie> listecategorie=new HashSet<>();
	
	public configuration(int i,String t,Spectacle s,Representation r) {
		id=i;
		type=t;
		spectacle=s;
		rep=r;
	}
	
	public configuration() {}
	
	public int getidconfig() {
		return id;
	}
	public String gettypeconfig() {
		return type;
	}
	public Representation getrep() {
		return rep;
	}
	public Spectacle getspect() {
		return spectacle;
	}
	public void setspect(Spectacle s) {
		spectacle=s;
	}
	public Categorie getcat(){
		return categorie;
	}
	public void setcat(Categorie c){
		categorie=c;
	}
}
