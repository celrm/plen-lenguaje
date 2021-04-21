package ast;

import java.util.List;

public class IfElse extends Instruction {

	private E b;
	private List<Instruction> list;

	public IfElse(E b, Instructions d) {
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
