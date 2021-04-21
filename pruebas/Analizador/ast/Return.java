package ast;

import exp.E;

public class Return extends Instruction {
	private E exp;
	public Return(E e) {
		this.exp=e;
	}
	public E exp() {
		return exp;
	}

}
