package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Reg extends Declare {
	private Typename tipo;
	private TV id;
	private List<E> values;
	public Reg(Typename tipo, TV id, HeterValues values) {
		this.tipo=tipo;
		this.id=id;

		if(values == null) 
			this.values = new ArrayList<E>();
		else
			this.values=values.list();
		type_of_dec=WhatDec.VARREG;
	}
	public Typename tipo() {
		return tipo;
	}
	public TV id() {
		return id;
	}
	public List<E> values() {
		return values;
	}

}
