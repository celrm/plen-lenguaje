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
		List<Typename> rets = new ArrayList<>();
		Typename meter = null;
		i.chequea();
		if(i.type_of_in == In.RETURN)
			meter = ((Return)i).tipo();
		if(rest!=null) 
			rets = rest.chequea();
		if(meter!=null) rets.add(meter);
		return rets;
	}
}
