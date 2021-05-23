package ast;

import alex.TV;

public class ENew extends E {
	Typename t; 
	TV tam;
	public ENew(Typename t, TV tam, Op basicoNew, int fila) {
		super(basicoNew,fila);
		this.t=t;
		this.tam = tam;
	}
	public String toString() {
		return "(new ("+t.toString() + "))";
	}
	Declare d;
	@Override
	public void vinculo() throws Exception {}
	@Override
	public Typename chequea() {
		tipo= new Typename(t.pure(),Type.PUNT);
		return tipo;
	}
	
	@Override
	protected String codigoE() {
		return "i32.const "+tam.toString()+"\n"
				+ "call $reserveHeap\n"
				+ "get_global $NP\n"
				;
	}
	@Override
	protected String codigoD() {
		// TODO Auto-generated method stub
		return null;
	}

}
