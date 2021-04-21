package ast;

import java.util.ArrayList;
import java.util.List;

import exp.E;

public class HomogValues {
	private E e;
	private HomogValues rest;
	public HomogValues(E e, HomogValues rest) {
		this.e=e;
		this.rest=rest;
	}
	public List<E> list() {

		List<E> sol;
		if(rest == null) {
			sol = new ArrayList<E>();
		}
		else sol = rest.list();

		sol.add(e);
		return sol;
	}
	
}
