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
	protected String chequea() throws Exception {
		String s1 = o1.chequea();
		String s2 = o2.chequea();
		switch(oper()) {
		case OR:
		case AND:
			if(!s1.equals("bul") || !s2.equals("bul"))
				throw new Exception(oper()+" de no bul");
			return "bul";
		case ARRAYINIT:
			if(!s1.equals("ent"))
				throw new Exception("Mal arrayinit tipo");
			return "arr\\"+s2;
		case DISTINTO:
		case IGUAL:
			if(!s1.equals(s2))
				throw new Exception(oper() +" mal tipo");
			return "bul";
		case MAQ:
		case MAYOR:
		case MENOR:
		case MEQ:
			if(!s1.equals("ent") || !s2.equals("ent"))
				throw new Exception(oper()+" de no ent");
			return "bul";
		case DIV:
		case MOD:
		case MUL:
		case RESTA:
		case SUMA:
			if(!s1.equals("ent") || !s2.equals("ent"))
				throw new Exception(oper()+" de no ent");
			return "ent";
		default:
			break;
		}
		return null;
	}
}
