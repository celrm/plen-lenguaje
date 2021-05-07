package ast;

import alex.TV;

public class ForDec extends Declare {
	private TV elem;
//	private For f;
	public ForDec(TV elem,For f) {
		this.elem = elem;
//		this.f = f;
		type_of_dec = Dec.FORDEC;
		type_of_in = In.DECLARE;
	}
	public String toString() {
		return elem.toString();
	}
	@Override
	protected void vinculo() throws Exception {}
	@Override
	protected void chequea() {}
	Typename tipo;
	@Override
	protected Typename tipo() {
		return tipo;
	}
}
