package ast;

public class Decvarreg extends Declares {

	public Decvarreg(Reg var, Declares rest) {
		super(var,rest);
		type_of_dec = WhatDec.VARREG;
	}
}
