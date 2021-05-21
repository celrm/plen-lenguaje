package ast;

public class EMono extends E {
	private E o;
	public EMono(E opnd1, Op oper, int fila) {
		super(oper,fila);
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
	protected Typename chequea() throws Exception {
		Typename s1 = o.chequea().pure();
		switch(oper()) {
		case NOT:
			if(s1.t != Type.BUL)
				throw new Exception("Fila " + fila + ". Not tipo");
			return s1;
		case SIGNO:
			if(s1.t != Type.ENT)
				throw new Exception("Fila " + fila + ". Signo tipo");
			return s1;
		default:
			break;
		
		}
		return null;
	}
	@Override
	protected String codigo() {
		String sol = "";
		String e1 = o.codigo();
		sol = sol + e1 ;
		switch(oper()) {
		case NOT:
//			sol = sol +
//			"i32.neg" TODO
//			;
			break;
		case SIGNO:
			sol = sol +
					"i32.const -1\n"+
					"i32.mul"
			;
			break;
		default:
			break;
		
		}
		return sol + "\n";
	}
}
