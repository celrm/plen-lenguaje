package ast;

import java.util.ArrayList;
import java.util.List;

public class Else extends Instruction {
	List<Instruction> lista;
	public Else(Instructions d) {
		if(d == null) 
			lista = new ArrayList<Instruction>();
		else
			lista=d.list();
	}

}
