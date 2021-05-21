package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class ForDec extends Declare {
	private TV elem;
//	private For f;
	public ForDec(TV elem,For f, int fila) {
		super(fila);
		this.elem = elem;
//		this.f = f;
		type_of_dec = Dec.FORDEC;
	}
	public String toString() {
		return elem.toString();
	}
	@Override
	protected void vinculo() throws Exception {
		if(name().equals("length") || name().equals("kin")) {
			throw new Exception("Fila " + fila + ". Banned word: "+ name());
		}
	}
	protected String name() {
		return elem.toString();
	}
	@Override
	protected List<Typename> chequea() {return new ArrayList<>();}
	Typename tipo;
	@Override
	protected Typename tipo() {
		return tipo;
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max, WrapInt delta) {
		// TODO Auto-generated method stub
		
	}
}
