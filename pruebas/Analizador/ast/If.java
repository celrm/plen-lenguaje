package ast;

import java.util.ArrayList;
import java.util.List;

public class If extends Instruction {
	private E b;
	private List<Instruction> list;
	public If(E b, Instructions d) {
		this.b=b;
		if(d == null) 
			this.list = new ArrayList<Instruction>();
		else
			this.list=d.list();
	}
	public E b() {
		return b;
	}
	public List<Instruction> list() {
		return list;
	}

}
