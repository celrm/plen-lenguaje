package ast;

import java.util.List;

import alex.TV;

public class Reg extends Declare {
	private Typename tipo;
	private TV id;
	private List<E> values;
	public Reg(Typename tipo, TV id, HeterValues values) {
		this.tipo=tipo;
		this.id=id;
		this.values=values.list();
	}
	public Typename tipo() {
		return tipo;
	}
	public TV id() {
		return id;
	}
	public List<E> values() {
		return values;
	}

}
