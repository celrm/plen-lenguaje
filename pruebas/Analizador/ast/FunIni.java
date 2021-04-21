package ast;

import java.util.List;

import alex.TV;

public class FunIni extends Declare {
	private TV id;
	private Typename tipo;
	private List<Param> params;
	private List<Instruction> d;
	public FunIni(TV id, Typename tipo, Params params, Instructions d) {
		type_of_dec = WhatDec.FUNCTION;
		this.id=id;
		this.tipo=tipo;
		this.params=params.list();
		this.d=d.list();
	}
	public TV id() {
		return id;
	}
	public Typename tipo() {
		return tipo;
	}
	public List<Param> params() {
		return params;
	}
	public List<Instruction> list() {
		return d;
	}

}
