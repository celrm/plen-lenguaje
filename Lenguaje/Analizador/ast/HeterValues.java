package ast;

import java.util.ArrayList;
import java.util.List;

public class HeterValues {
	private E e;
	private HeterValues rest;
	public HeterValues(E e, HeterValues rest) {
		this.e=e;
		this.rest=rest;
	}
	private List<E> list() {
		List<E> sol;
		if(rest == null) {
			sol = new ArrayList<E>();
		}
		else sol = rest.list();

		if(e!=null)
			sol.add(0,e);
		return sol;
	}
	// acaba en coma fea
	public String toString() {
		String sol = "";
		for(E d : list()) {
			sol = sol + d.toString() + ",";
		}
		return sol;
	}
	public void vinculo() throws Exception {
		e.vinculo();
		if(rest!=null)
			rest.vinculo();
	}
}
