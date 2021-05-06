package ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Declares {
	private Declare var;
	private Declares rest;
	public Declares(Declare var, Declares rest, Dec dectype) {
		this.var= var;
		this.rest=rest;
		var.type_of_dec = dectype;
	}
	private List<Declare> list() {
		List<Declare> sol;
		if(rest == null) {
			sol = new ArrayList<Declare>();
		}
		else sol = rest.list();
		if(var!=null)
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
	public void vinculo() throws Exception {
		var.vinculo();
		if(rest!=null)
			rest.vinculo();
	}
	public void chequea_prep(Map<String, Typename> typedefs) {
		if(var.type_of_dec == Dec.TYPE)
			((DefType) var).chequea_prep(typedefs);
		if(rest!=null)
			rest.chequea_prep(typedefs);
	}
	public void chequea() {
		var.chequea();
		if(rest!=null)
			rest.chequea();
	}
}
