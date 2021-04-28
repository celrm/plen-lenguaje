package ast;

import alex.TV;

public class EBasico extends E {
	TV id;
	public EBasico(TV id) {
		super(Op.BASICO);
		this.id = id;
	}
	public String toString() {
		return id.toString();
	}

}
