package ast;

import java.util.ArrayList;
import java.util.List;

public class Instructions {
	private Instruction i;
	private Instructions rest;
	public Instructions(Instruction i, Instructions rest) {
		this.i=i;
		this.rest=rest;
	}

	public List<Instruction> list() {
		List<Instruction> sol;
		if(rest == null) {
			sol = new ArrayList<Instruction>();
		}
		else sol = rest.list();

		sol.add(i);
		return sol;
	}
}
