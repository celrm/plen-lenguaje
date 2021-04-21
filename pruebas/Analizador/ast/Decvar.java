package ast;

public class Decvar extends Declares {

	public Decvar(Var var, Declares rest) {
		super(var,rest);
		type_of_dec = WhatDec.VAR;
	}
}
