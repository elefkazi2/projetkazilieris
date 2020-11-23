package classesPojo;

import java.util.Date;

public class PlaningSalle {
	
	private int id;
	private Date datedebut;
	private Date datefin;
	private int idpers;
	
	public PlaningSalle() {}
	public PlaningSalle(Date datedebut,Date datefin,int idpers) {
		this.datedebut=datedebut;
		this.datefin=datefin;
		this.idpers=idpers;
	}
	
	public Date getdd() {
		return datedebut;
	}
	public Date getdf() {
		return datefin;
	}
	public int getidpers() {
		return idpers;
	}

}
