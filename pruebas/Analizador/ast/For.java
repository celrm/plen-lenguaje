package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class For extends Instruction {
	private TV elem;
	private E arr;
	private List<Instruction> lista;
	public For(TV elem, E arr, Instructions d) {
		this.elem=elem;
		this.arr=arr;
		if(d == null) 
			lista = new ArrayList<Instruction>();
		else
			lista=d.list();
	}
	public TV elem() {
		return elem;
	}
	public E arr() {
		return arr;
	}
	public List<Instruction> list() {
		return lista;
	}

}
