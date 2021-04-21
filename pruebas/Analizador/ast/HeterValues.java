package ast;

import java.util.ArrayList;
import java.util.List;

import exp.E;

public class HeterValues {
	private E e;
	private HeterValues rest;
	public HeterValues(E e, HeterValues rest) {
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
