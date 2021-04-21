package ast;

import java.util.List;

public class Else extends Instruction {
	List<Instruction> lista;
	public Else(Instructions d) {
		lista=d.list();
	}

}
