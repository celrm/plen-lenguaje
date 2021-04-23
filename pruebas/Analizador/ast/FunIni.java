package ast;

import java.util.ArrayList;
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
		if(params == null) 
			this.params = new ArrayList<Param>();
		else
			this.params=params.list();
		if(d == null) 
			this.d = new ArrayList<Instruction>();
		else
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
