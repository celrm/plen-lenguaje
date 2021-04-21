package ast;

import exp.E;

public class Kut extends Instruction {
	private String print;
	public Kut(E i) {
		print=i.toString();
	}
	public String print() {
		return print;
	}

}
