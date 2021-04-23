package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class RegIni extends Declare {
	private TV id;
	private List<Param> pars;
	private List<Declare> decs;
	public RegIni(TV id, Params params, Declares d) {
		type_of_dec=WhatDec.REGISTER;
		this.id=id;

		if(params == null) 
			pars = new ArrayList<Param>();
		else
			pars=params.list();

		if(d == null) 
			decs = new ArrayList<Declare>();
		else
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
