package ast;

import alex.TV;

public class Param {
	private Typename tipo;
	private TV id;
	boolean is_const=false;
	public Param(Typename tipo, TV id) {
		this.tipo = tipo;
		this.id = id;
	}
	public String toString() {
		String sol = tipo.toString() + " ";
		sol = sol + id.toString();
		return (is_const?"const " :"") + sol;
	}
}
