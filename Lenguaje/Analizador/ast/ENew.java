package ast;

public class ENew extends E {
	Typename t;
	public ENew(Typename t, Op basicoNew, int fila) {
		super(basicoNew,fila);
		this.t=t;
	}
	public String toString() {
		return "(new ("+t.toString() + "))";
	}
	Declare d;
	@Override
	public void vinculo() throws Exception {}
	@Override
	public Typename chequea() {
		return new Typename(t.pure(),Type.PUNT);
	}

}
