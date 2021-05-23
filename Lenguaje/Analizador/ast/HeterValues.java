package ast;

public class HeterValues {
	E e;
	Param p;
	HeterValues rest;
	public HeterValues(E e, HeterValues rest) {
		this.e=e;
		this.rest=rest;
	}
	public String toString() {
		String sol = e.toString();
		if (rest!=null) {
			sol = sol + ",";
			sol = sol + rest.toString();
		}
		return sol;
	}
	public void vinculo() throws Exception {
		e.vinculo();
		if(rest!=null)
			rest.vinculo();
	}
	public void chequea() throws Exception {
		e.chequea();
		if(rest!=null)
			rest.chequea();
	}
	public String codigo(int i) {
		String codeE = "";
		String lsol = "";
		if(e.tipo.t == Type.ARR) {
			if(e.oper() == Op.BASICO_ID) {
//				Declare d = ((EBasico)e).d;
//				codeE = ((ListInit)d).codigo(i,true)
//						+ "\n";
//				lsol = codeE;
			}
			else if(e.oper() == Op.LISTA) {
				codeE = ((ListInit)e).codigo(i,true)
						+ "\n";
				lsol = codeE;
			}
		}
		else 
			{
			lsol = 
				"	get_global $SP\n" +
				"   i32.const " + i * 4 + "\n"+
				"	i32.add\n" +
				e.codigo() + "\n"+
				"i32.store\n"
				;

		}
		if(rest!= null) {
			int next = i+e.tipo.size();
			lsol = lsol + rest.codigo(next);
		}
		return lsol;
	}
}
