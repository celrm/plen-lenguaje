package ast;

import java.util.ArrayList;
import java.util.List;

public class Declares {
	private Declare var;
	private Declares rest;
	WhatDec type_of_dec;
	public Declares(Declare var, Declares rest) {
		this.var= var;
		this.rest=rest;
	}

	public List<Declare> list() {
		List<Declare> sol;
		if(rest == null) {
			sol = new ArrayList<Declare>();
		}
		else sol = rest.list();

		sol.add(var);
		return sol;
	}

}
