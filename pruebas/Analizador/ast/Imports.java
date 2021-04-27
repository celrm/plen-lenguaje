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
	// cuidado está al revés
	private List<Import> list() {
		List<Import> sol;
		if(rest == null) {
			sol = new ArrayList<Import>();
		}
		else sol = rest.list();

		sol.add(i);
		return sol;
	}
	public String toString() {
		String sol = "";
		for(Import d : list()) {
			sol = sol + d.toString() + "\n";
		}
		return sol;
	}
}
