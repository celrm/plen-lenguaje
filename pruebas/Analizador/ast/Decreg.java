package ast;

public class Decreg extends Declares {

	public Decreg(RegIni var, Declares rest) {
		super(var,rest);
		type_of_dec = WhatDec.REGISTER;
	}
}
