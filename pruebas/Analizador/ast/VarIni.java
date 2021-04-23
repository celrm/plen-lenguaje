package ast;

import alex.TV;

public class VarIni {
	private Typename tipo;
	private TV id;
	private E exp;
	public VarIni(Typename tipo, TV id, E exp2) {
		this.tipo=tipo;
		this.id=id;
		this.exp=exp2;
	}
	public Typename tipo() {
		return tipo;
	}
	public TV id() {
		return id;
	}
	public E exp() {
		return exp;
	}
	public String toString() {
		String sol = tipo.toString() + " ";
		sol = sol + id.toString() + " = (";
		sol = sol + exp.toString() + ")";
		return sol;
	}

}
