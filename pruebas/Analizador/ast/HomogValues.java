package ast;

import java.util.ArrayList;
import java.util.List;

public class HomogValues {
	private E e;
	private HomogValues rest;
	public HomogValues(E e, HomogValues rest) {
		this.e=e;
		this.rest=rest;
	}
	// cuidado está al revés
	private List<E> list() {
		List<E> sol;
		if(rest == null) {
			sol = new ArrayList<E>();
		}
		else sol = rest.list();

		sol.add(e);
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
}
