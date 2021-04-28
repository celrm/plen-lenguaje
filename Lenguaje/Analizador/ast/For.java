package ast;

import alex.TV;

public class For extends Instr {
	private TV elem;
	private E arr;
	private Instructions lista;
	public For(TV elem, E arr, Instructions d) {
		this.elem=elem;
		this.arr=arr;
		lista=d;
	}
	public String toString() {
		String sol =  "for (" + elem.toString() + " : " + arr.toString();
		sol = sol +  ") {\n" + (lista==null?"":lista.toString())+ "}";  
		return sol;
	}
}
