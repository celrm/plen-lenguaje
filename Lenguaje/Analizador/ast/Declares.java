package ast;

import java.util.Map;

public class Declares {
	private Declare var;
	private Declares rest;
	public Declares(Declare var, Declares rest, Dec dectype) {
		this.var= var;
		this.rest=rest;
		var.type_of_dec = dectype;
	}
	public String toString() {
		String sol = var.toString() + "\n";
		if (rest!=null) {
			sol = sol + rest.toString();
		}
		return sol;
	}
	public void vinculo() throws Exception {
		var.vinculo();
		if(rest!=null)
			rest.vinculo();
	}
	public void chequea_prep(Map<Typename, Typename> typedefs) {
		if(var.type_of_dec == Dec.TYPE)
			((DefType) var).chequea_prep(typedefs);
		if(rest!=null)
			rest.chequea_prep(typedefs);
	}
	public void chequea() throws Exception {
		var.chequea();
		if(rest!=null)
			rest.chequea();
	}
}
