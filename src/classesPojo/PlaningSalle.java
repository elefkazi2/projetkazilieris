package classesPojo;

import dao.AbstractDAOFactory;
import dao.DAO;

public class PlaningSalle {
	
	private int id;
	private String datedebut;
	private String datefin;
	private int idpers;
	private Spectacle spectacle;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<PlaningSalle> pldao = adf.getpl();
	
	public PlaningSalle() {}
	public PlaningSalle(int id,String datedebut,String datefin,Spectacle s) {
		this.datedebut=datedebut;
		this.datefin=datefin;
		this.id=id;
		spectacle=s;
	}
	public PlaningSalle(String datedebut,String datefin,int idpers) {
		this.datedebut=datedebut;
		this.datefin=datefin;
		this.idpers=idpers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getdd() {
		return datedebut;
	}
	public String getdf() {
		return datefin;
	}
	public int recup_dernier_pl(){
		return pldao.find();
	}
	public int getidpers() {
		return idpers;
	}
	public Spectacle getspect() {
		return spectacle;
	}
	public void setspect(Spectacle s) {
		spectacle=s;
	}
	public PlaningSalle all(int id) {
		PlaningSalle r=pldao.find(id);
		return new PlaningSalle(r.id,r.datedebut,r.datefin,r.spectacle);
	}
	public void ajout_planingsalle(String datedebut,String datefin,int idpers) {
		PlaningSalle s=new PlaningSalle( datedebut, datefin, idpers);
		pldao.create(s);		
	}
}
