package ast;

public class Dectype extends Declares {

	public Dectype(TypeIni var, Declares rest) {
		super(var,rest);
		type_of_dec = WhatDec.TYPE;
	}

}
