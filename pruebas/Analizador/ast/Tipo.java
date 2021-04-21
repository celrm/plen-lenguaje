package ast;

import alex.TV;

public enum Tipo {
	Array(),
	Ent(),
	Bul(),
	Id(),
	Car();

	private Tipo in;
	private TV id;
	Tipo() {}
	Tipo(Tipo t) {
		in=t;
	}
	Tipo(TV t) {
		id=t;
	}
	public Tipo inside() {
		return in;
	}
	public TV id() {
		return id;
	}
}
