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
	private List<Instr> list() {
		List<Instr> sol;
		if(rest == null) {
			sol = new ArrayList<Instr>();
		}
		else sol = rest.list();
		if(i!=null)
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
	public void vinculo() throws Exception {
		i.vinculo();
		if(rest!=null)
			rest.vinculo();
	}
	public List<Typename> chequea() throws Exception {
		List<Typename> i_rets = i.chequea();
		List<Typename> all_rets = new ArrayList<>();

		if(rest!=null) 
			all_rets = rest.chequea();
		
		for (Typename meter : i_rets) {
			all_rets.add(meter);
		}
		return all_rets;
	}
}
