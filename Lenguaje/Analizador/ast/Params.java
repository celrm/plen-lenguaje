package ast;

import alex.TV;

public class Params {
	Param p;
	Params rest; 
	public Params(Typename tipo, TV id, Params rest, boolean is_const2) {
		p = new Param(tipo,id);
		this.rest = rest;
		p.isconst=is_const2;
	}
	public String toString() {
		String sol = p.toString();
		if (rest!=null) {
			sol = sol + ",";
			sol = sol + rest.toString();
		}
		return sol;
	}
	public void vinculo() throws Exception {
		p.vinculo();
		if(rest!=null)
			rest.vinculo();
	}
	public int size() {
		int size = p.size();
		if(rest!=null)
			size = size+rest.size();
		return size;
	}
	public void maxMemory(WrapInt c, WrapInt max, WrapInt delta) {
		p.maxMemory(c,max,delta);
		if(rest != null)
		rest.maxMemory(c,max,delta);
	}
}
