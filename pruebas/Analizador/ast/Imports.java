package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Imports {
	TV name;
	TV source;
	Imports rest;
	public Imports(TV name, TV source, Imports rest) {
		this.name=name;
		this.source=source;
		this.rest=rest;
	}
	public List<Import> list() {

		List<Import> sol;
		if(rest == null) {
			sol = new ArrayList<Import>();
		}
		else sol = rest.list();

		sol.add(new Import(name,source));
		return sol;
	}

}
