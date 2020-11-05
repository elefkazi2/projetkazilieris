package classesPojo;

public class Place {
	
	private int numplace;
	private int nbreplacemax=15;
	//voir diag classe pour rajouter liste representation on verra la correction si ca restera avec madame
	
	public Place(int n) {
		numplace=n;
	}
	public int getPlacenomb() {
		return numplace;
	}
	public int getPlaceMax() {
		return nbreplacemax;
	}
	@Override
	public String toString() {
		if(numplace>=nbreplacemax) {
			return "vous ne pouvez pas prendre autant de places ";
		}
		return " pour un nombre de "+numplace+" places";
	}	

}
