package ast;

import alex.TV;

public class Params {
	Param p;
	Params rest; 
	public Params(Typename tipo, TV id, Params rest, boolean is_const2) {
		p = new Param(tipo,id);
		this.rest = rest;
		p.is_const=is_const2;
	}
	public String toString() {
		String sol = p.toString();
		if (rest!=null) {
			sol = sol + ",";
			sol = sol + rest.toString();
		}
		return sol;
	}
	public void vinculo() {
		p.vinculo();
		if(rest!=null)
			rest.vinculo();
	}
}
