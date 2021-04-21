package ast;

import java.util.List;

import alex.TV;

public class RegIni extends Declare {
	private TV id;
	private List<Param> pars;
	private List<Declare> decs;
	public RegIni(TV id, Params params, Declares d) {
		type_of_dec=WhatDec.REGISTER;
		this.id=id;
		pars=params.list();
		decs=d.list();
	}
	public TV id() {
		return id;
	}
	public List<Param> params() {
		return pars;
	}
	public List<Declare> decs() {
		return decs;
	}

}
