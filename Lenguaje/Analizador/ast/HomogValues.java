package ast;

public class HomogValues {
	private E e;
	private HomogValues rest;
	int fila;
	public HomogValues(E e, HomogValues rest) {
		this.e=e;
		this.rest=rest;
		this.fila = e.fila;
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
	public Typename chequea() throws Exception {
		Typename t = e.chequea();
		Typename w;
		if(rest!= null) {
			w = rest.chequea();
			if(!t.equals(w))
				throw new Exception("Fila " + fila + ". Bad list"); // mirar tamaños varios de arrays [[],[1]]
		}
		return t;
	}
}
