package classesPojo;

import java.util.ArrayList;
import java.util.List;

public class Gestionnaire extends Personne{
	
	private List<PlaningSalle> listeplaning= new ArrayList<>();
	public Gestionnaire() {}
	public Gestionnaire(String nu,String n,String pr,String ad,String pa,String r) {
		super(nu,n,pr,ad,pa,r);
	}

}
