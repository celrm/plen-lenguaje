package ast;

import alex.TV;

public class Imports {
	Import i;
	Imports rest;
	public Imports(TV name, TV source, Imports rest) {
		this.i= new Import(name,source);
		this.rest=rest;
	}
	public String toString() {
		String sol = i.toString() + "\n";
		if (rest!=null) {
			sol = sol + rest.toString();
		}
		return sol;
	}
	public void vinculo() throws Exception {
		i.vinculo();
		if(rest!=null)
			rest.vinculo();
	}
	public void chequea() {
		i.chequea();
		if(rest!=null)
			rest.chequea();
	}
}
