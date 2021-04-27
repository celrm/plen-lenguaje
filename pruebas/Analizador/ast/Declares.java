package ast;

import java.util.ArrayList;
import java.util.List;

public class Declares {
	private Declare var;
	private Declares rest;
	public Declares(Declare var, Declares rest, Dec dectype) {
		this.var= var;
		this.rest=rest;
		var.type_of_dec = dectype;
	}
	// cuidado está al revés
	private List<Declare> list() {
		List<Declare> sol;
		if(rest == null) {
			sol = new ArrayList<Declare>();
		}
		else sol = rest.list();
		sol.add(0, var);
		return sol;
	}	
	public String toString() {
		String sol = "";
		for(Declare d : list()) {
			sol = sol + d.toString() + "\n";
		}
		return sol;
	}
}
