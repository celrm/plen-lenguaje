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
		Typename t = e.tipo;
		int s = t.size();
		return "get_global $SP\n" +
				"i32.const "+i * s * 4+"\n"+
				"i32.add\n"+
				e.codigo() + 
				"i32.store\n" + 
				(rest==null?"":rest.codigo(i+1));
	}
}
