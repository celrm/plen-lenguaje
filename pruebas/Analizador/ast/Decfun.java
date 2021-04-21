package ast;

public class Decfun extends Declares {

	public Decfun(FunIni var, Declares rest) {
		super(var,rest);
		type_of_dec = WhatDec.FUNCTION;
	}

}
