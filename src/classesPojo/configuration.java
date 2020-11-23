package classesPojo;

import java.util.*;

public class configuration {
	
	private int id;
	private String type;
	private int idspect;
	private int idrep;
	//private Spectacle spectacle;
	//private Representation rep;
	private Categorie categorie;
	//private Set<Categorie> listecategorie=new HashSet<>();
	
	/*public configuration(int i,String t,Spectacle s,Representation r) {
		id=i;
		type=t;
		spectacle=s;
		rep=r;
	}*/
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
	public void setspect(int s) {
		idspect=s;
	}
	public Categorie getcat(){
		return categorie;
	}
	public void setcat(Categorie c){
		categorie=c;
	}
}
