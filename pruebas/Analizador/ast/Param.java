package ast;

import alex.TV;

public class Param {
	private Typename tipo;
	private TV id;
	public Param(Typename tipo, TV id) {
		this.tipo = tipo;
		this.id = id;
	}
	public Typename tipo() {
		return tipo;
	}
	public TV id() {
		return id;
	}
}
