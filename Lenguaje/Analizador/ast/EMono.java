package ast;

public class EMono extends E {
	private E o;
	public EMono(E opnd1, Op oper) {
		super(oper);
		this.o = opnd1;
	}
	public String toString() {
		return this.oper().toString() + " " + o.toString();
	}
	@Override
	protected void vinculo() throws Exception {
		o.vinculo();
	}
	@Override
	protected String chequea() {
		// TODO Auto-generated method stub
		return null;
	}
}
