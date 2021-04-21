package ast;

import java.util.List;

import exp.E;

public class While extends Instruction {

	private E b;
	private List<Instruction> list;
	public While(E b, Instructions d) {
		this.b=b;
		this.list=d.list();
	}
	public E b() {
		return b;
	}
	public List<Instruction> list() {
		return list;
	}

}
