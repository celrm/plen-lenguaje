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
	private boolean errorSemantico = false;
	public void vinculo() {
		try {
			i.vinculo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
			errorSemantico = true;
		}
		if(rest!=null)
			rest.vinculo();
	}
	public List<Typename> chequea() {
		List<Typename> i_rets = new ArrayList<>();
		List<Typename> all_rets = new ArrayList<>();
		
		if(!errorSemantico)
			try {
				i_rets = i.chequea();
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println(e.getMessage());
			}

		if(rest!=null) 
			all_rets = rest.chequea();
		
		for (Typename meter : i_rets) {
			all_rets.add(meter);
		}
		return all_rets;
	}
}
