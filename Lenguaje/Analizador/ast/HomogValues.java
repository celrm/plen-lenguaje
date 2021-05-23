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
	public int vinculo() throws Exception {
		int sol = 0;
		e.vinculo();
		if(rest!=null)
			sol = rest.vinculo();
		return sol+1;
	}
	public Typename chequea() throws Exception {
		Typename t = e.chequea().pure();
		Typename w;
		if(rest!= null) {
			w = rest.chequea().pure();
			if(!t.equals(w))
				throw new Exception("Fila " + fila + ". Bad list"); // mirar tamaños varios de arrays [[],[1]]
		}
		return t;
	}
	public String codigo(int delta, boolean hom) {
		String codeE = "";
		String lsol = "";
		if(e.tipo.t == Type.ARR) {
			if(e.oper() == Op.LISTA) {
				codeE = ((ListInit)e).codigo(delta,hom)
						+ "\n";

				lsol = codeE;
			}
		}
		else 
			{
			lsol = 
				(hom?"	get_global $SP\n":
				"	get_local $localsStart\n") +
				"   i32.const " + delta * 4 + "\n"+
				"	i32.add\n" +
				e.codigoE() + "\n"+
				"i32.store\n"
				;
			System.out.println(this + "  " +hom);

		}
		if(rest!= null) {
			int next = delta+e.tipo.size();
			lsol = lsol + rest.codigo(next,hom);
		}
		return lsol;
	}
}
