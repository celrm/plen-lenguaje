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
	protected String chequea() throws Exception {
		String s1 = o.chequea();
		switch(oper()) {
		case NOT:
			if(!s1.equals("bul"))
				throw new Exception("not tipo");
			return "bul";
		case SIGNO:
			if(!s1.equals("ent"))
				throw new Exception("signo tipo");
			return "ent";
		default:
			break;
		
		}
		return null;
	}
}
