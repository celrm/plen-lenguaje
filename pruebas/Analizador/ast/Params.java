package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Params {
	boolean is_const=false;
	private Typename tipo;
	private TV id;
	private Params rest; 
	public Params(Typename tipo, TV id, Params rest) {
		this.tipo = tipo;
		this.id = id;
		this.rest = rest;
	}
	public List<Param> list() {
		List<Param> sol;
		if(rest == null) {
			sol = new ArrayList<Param>();
		}
		else sol = rest.list();

		sol.add(new Param(tipo,id));
		return sol;
	}
}
