package ast;

public class Var extends Declare {
	boolean is_const;
	private VarIni var;
	public Var(VarIni var) {
		this.var=var;
		type_of_dec=WhatDec.VAR;
	}
	public VarIni var() {
		return var;
	}
	public String toString() {
		String sol = is_const?"cons ":"";
		sol = sol + var.toString();
		return sol;
	}
}
