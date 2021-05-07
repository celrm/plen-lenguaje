package ast;

public class EBin extends E {
   private E o1;
   private E o2;
   public EBin(E opnd1, E opnd2, Op oper) {
	   super(oper);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
	public String toString() {
		return "("+o1.toString() + " " + this.oper().toString() + " " + o2.toString()+")";
	}
	@Override
	protected void vinculo() throws Exception {
		o1.vinculo();
		o2.vinculo();
	}
	@Override
	protected Typename chequea() throws Exception {
		Typename s1 = o1.chequea();
		Typename s2 = o2.chequea();
		switch(oper()) {
		case OR:
		case AND:
			if(s1.t != Type.BUL || s2.t != Type.BUL)
				throw new Exception(oper()+" de no bul");
			return new Typename("bul");
		case ARRAYINIT:
			if(s1.t != Type.ENT)
				throw new Exception("Mal arrayinit tipo");
			return new Typename(s2);
		case DISTINTO:
		case IGUAL:
			if(!s1.equals(s2))
				throw new Exception(oper() +" mal tipo");
			return new Typename("bul");
		case MAQ:
		case MAYOR:
		case MENOR:
		case MEQ:
			if(s1.t != Type.ENT || s2.t != Type.ENT)
				throw new Exception(oper()+" de no ent");
			return new Typename("bul");
		case DIV:
		case MOD:
		case MUL:
		case RESTA:
		case SUMA:
			if(s1.t != Type.ENT || s2.t != Type.ENT)
				throw new Exception(oper()+" de no ent");
			return new Typename("ent");
		default:
			break;
		}
		return null;
	}
}
