package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Params {
	private Param p;
	private Params rest; 
	public Params(Typename tipo, TV id, Params rest, boolean is_const2) {
		p = new Param(tipo,id);
		this.rest = rest;
		p.is_const=is_const2;
	}
	private List<Param> list() {
		List<Param> sol;
		if(rest == null) {
			sol = new ArrayList<Param>();
		}
		else sol = rest.list();

		if(p!=null)
			sol.add(0,p);
		return sol;
	}
	// acaba en coma fea
	public String toString() {
		String sol = "";
		for(Param d : list()) {
			sol = sol + d.toString() + ",";
		}
		return sol;
	}
	public void vinculo() {
		// TODO Auto-generated method stub
		
	}
}
