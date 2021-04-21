package ast;

import alex.TV;

public class VarIni {
	private Typename tipo;
	private TV id;
	private E exp;
	public VarIni(Typename tipo, TV id, E exp) {
		this.tipo=tipo;
		this.id=id;
		this.exp=exp;
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

}
