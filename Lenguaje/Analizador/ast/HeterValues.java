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
		String lsol = "";
		if(e.tipo != null && e.tipo.t == Type.ARR) {
			if(e.oper() == Op.BASICO_ID) {
				lsol = e.codigoD() + "\n"+ // src
						"	get_global $SP\n" +
						"   i32.const " + i * 4 + "\n"+
						"	i32.add\n" + //dst
						"	i32.const "+ e.tipo.shape+ "\n"+
						"	call $copyn\n"
						;
			}
			else if(e.oper() == Op.LISTA) {
				lsol = ((ListInit)e).codigo(i,true)
						+ "\n";
			}
		}
		else 
			{
			lsol = 
				"	get_global $SP\n" +
				"   i32.const " + i * 4 + "\n"+
				"	i32.add\n" +
				e.codigoE() + "\n"+
				"i32.store\n"
				;

		}
		if(rest!= null) {
			int next = i+(e.tipo != null?e.tipo.shape.v:1);
			lsol = lsol + rest.codigo(next);
		}
		return lsol;
	}
}
