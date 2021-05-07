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
}
