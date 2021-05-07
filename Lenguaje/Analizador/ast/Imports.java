package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Imports {
	Import i;
	Imports rest;
	public Imports(TV name, TV source, Imports rest) {
		this.i= new Import(name,source);
		this.rest=rest;
	}
	private List<Import> list() {
		List<Import> sol;
		if(rest == null) {
			sol = new ArrayList<Import>();
		}
		else sol = rest.list();

		if(i!=null)
			sol.add(0,i);
		return sol;
	}
	public String toString() {
		String sol = "";
		for(Import d : list()) {
			sol = sol + d.toString() + "\n";
		}
		return sol;
	}
	public void vinculo() {
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
