package ast;

import java.util.Map;

public class Declares {
	private Declare var;
	private Declares rest;
	public Declares(Declare var, Declares rest, Dec dectype) {
		this.var= var;
		this.rest=rest;
		var.type_of_dec = dectype;
	}
	public String toString() {
		String sol = var.toString() + "\n";
		if (rest!=null) {
			sol = sol + rest.toString();
		}
		return sol;
	}
	private boolean errorSemantico = false;
	public void vinculo() {
		try {
			var.vinculo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
			errorSemantico = true;
		}
		if(rest!=null)
			rest.vinculo();
	}
	public void chequea_prep(Map<String, Typename> typedefs) {
		if(var.type_of_dec == Dec.TYPE)
			((DefType) var).chequea_prep(typedefs);
		if(rest!=null)
			rest.chequea_prep(typedefs);
	}
	public void chequea() {
		if(!errorSemantico)
			try {
				var.chequea();
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		if(rest!=null)
			rest.chequea();
	}
	public void maxMemory(WrapInt c, WrapInt max) {
			var.maxMemory(c,max);
			if(rest != null)
			rest.maxMemory(c,max);
	}
	public String codigo() {
		String is ="";
		if(var.type_of_dec==Dec.FUNCTION) // TODO de momento? 
		{
			is = is + ((DefFun) var).codigo();
			
		}
		if(rest!=null) 
			is = is+ rest.codigo();
		return is;
	}
}
