package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class ForDec extends Declare {
	private TV elem;
//	private For f;
	public ForDec(TV elem,For f) {
		this.elem = elem;
//		this.f = f;
		type_of_dec = Dec.FORDEC;
	}
	public String toString() {
		return elem.toString();
	}
	@Override
	protected void vinculo() throws Exception {}
	@Override
	protected List<Typename> chequea() {return new ArrayList<>();}
	Typename tipo;
	@Override
	protected Typename tipo() {
		return tipo;
	}
}
