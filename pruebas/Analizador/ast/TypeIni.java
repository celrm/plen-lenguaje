package ast;

import alex.TV;

public class TypeIni extends Declare {
	private TV id;
	private Typename tipo;

	public TypeIni(TV id, Typename tipo) {
		type_of_dec=WhatDec.TYPE;
		this.id=id;
		this.tipo=tipo;
	}

	public TV id() {
		return id;
	}
	public Typename tipo() {
		return tipo;
	}

}
