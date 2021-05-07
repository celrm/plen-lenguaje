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
	public String toString() {
		String sol = i.toString() + "\n";
		if (rest!=null) {
			sol = sol + rest.toString();
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
