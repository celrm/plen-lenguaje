package ast;

import java.util.ArrayList;
import java.util.List;

public class Instructions {
	private Instr i;
	private Instructions rest;
	public Instructions(Instr i, Instructions rest) {
		this.i=i;
		this.rest=rest;
	}
	// cuidado está al revés
	private List<Instr> list() {
		List<Instr> sol;
		if(rest == null) {
			sol = new ArrayList<Instr>();
		}
		else sol = rest.list();

		sol.add(0,i);
		return sol;
	}
	public String toString() {
		String sol = "";
		for(Instr d : list()) {
			sol = sol + d.toString() + "\n";
		}
		return sol;
	}
}
