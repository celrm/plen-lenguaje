package ast;

import alex.TV;

public class Imports {
	Import i;
	Imports rest;
	public Imports(TV name, TV source, Imports rest) {
		int fila = name.fila;
		this.i= new Import(name,source,fila);
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
	public void chequea() {
		if(!errorSemantico)
			i.chequea();
		if(rest!=null)
			rest.chequea();
	}
}
