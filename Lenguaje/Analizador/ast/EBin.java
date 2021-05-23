package ast;

public class EBin extends E {
   private E o1;
   private E o2;
   private EBasico a1;
int tam = 0;
   public EBin(E opnd1, E opnd2, Op oper, int fila) {
	   super(oper,fila);
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
		Typename s1 = o1.chequea().pure();
		Typename s2 = o2.chequea().pure();
		switch(oper()) {
		case OR:
		case AND:
			if(s1.t != Type.BUL || s2.t != Type.BUL)
				throw new Exception("Fila " + fila + ". " +oper()+" de no bul "
						+s1.t + " " + s2.t);
			tipo= new Typename("bul");
			return tipo;
		case ARRAYINIT:
			a1 = (EBasico) o1; // solo puede ser una constante
			if(s1.t != Type.ENT)
				throw new Exception("Fila " + fila + ". Mal arrayinit tipo "
						+s1.t);
			return new Typename(s2, Type.ARR);
		case DISTINTO:
		case IGUAL:
			if(!s1.equals(s2))
				throw new Exception("Fila " + fila + ". "+oper() +" mal tipo "
						+s1.t + " " + s2.t);
			tipo=  new Typename("bul");
			return tipo;
		case MAQ:
		case MAYOR:
		case MENOR:
		case MEQ:
			if(s1.t != Type.ENT || s2.t != Type.ENT)
				throw new Exception("Fila " + fila + ". "+oper()+" de no ent "
						+s1.t + " " + s2.t);
			tipo=  new Typename("bul");
			return tipo;
		case DIV:
		case MOD:
		case MUL:
		case RESTA:
		case SUMA:
			if(s1.t != Type.ENT || s2.t != Type.ENT)
				throw new Exception("Fila " + fila + ". "+oper()+" de no ent "
						+s1.t + " " + s2.t);
			tipo=  new Typename("ent");
			return tipo;
		default:
			break;
		}
		return null;
	}
	@Override
	protected String codigoE() {
		String sol = "";
		String e1 = o1.codigoE();
		String e2 = o2.codigoE();
		sol = sol + e1 + e2;
		switch(oper()) {
		case OR:
			sol = sol +
					"i32.or"
					;
			break;
		case AND:
			sol = sol +
			"i32.and"
			;
			break;
		case ARRAYINIT:
			tam = Integer.parseInt(e1.toString()); // TODO to do...
			break;
		case DISTINTO:
			sol = sol +
			"i32.ne"
			;
			break;
		case IGUAL:
			sol = sol +
			"i32.eq"
			;
			break;
		case MAQ:
			sol = sol +
			"i32.ge_s"
			;
			break;
		case MAYOR:
			sol = sol +
			"i32.gt_s"
			;
			break;
		case MENOR:
			sol = sol +
			"i32.lt_s"
			;
			break;
		case MEQ:
			sol = sol +
			"i32.le_s"
			;
			break;
		case DIV:
			sol = sol +
			"i32.div_s"
			;
			break;
		case MOD:
			sol = sol +
			"i32.rem_s"
			;
			break;
		case MUL:
			sol = sol +
			"i32.mul"
			;
			break;
		case RESTA:
			sol = sol +
			"i32.sub"
			;
			break;
		case SUMA:
			sol = sol +
			"i32.add"
			;
			break;
		default:
			break;
		}
		return sol + "\n";
	}
	@Override
	protected String codigoD() {
		// TODO Auto-generated method stub
		return null;
	}
}
