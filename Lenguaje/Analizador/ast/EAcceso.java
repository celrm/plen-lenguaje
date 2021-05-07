package ast;

public class EAcceso extends EBin {
   private E o1;
   private EBasico o2;
   public EAcceso(E opnd1, EBasico opnd2, Op oper) {
	   super(opnd1, opnd2, oper);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
   Reg r;
   DefReg dr;
   Declare acc;
	@Override
	protected void vinculo() throws Exception {
		if(o2.oper()!=Op.BASICO_ID)
			throw new Exception("Access: "+ o2.toString());
		
		if (o1.oper()==Op.BASICO_ID) {
			Declare d = (Declare) Program.buscaId(o1.toString());
			if(d.type_of_dec == Dec.PARAM) {
				
			}
			dr = r.dr;
			acc = (Declare) dr.get(o2.toString());
		}
		else if (o1.oper()==Op.ACCESO) {
			EAcceso o11 = (EAcceso) o1;
			o11.vinculo();
			r = (Reg) o11.acc;
			dr = r.dr;
			acc = (Declare) dr.get(o2.toString());
		}
		else 
			throw new Exception("Access: "+ o2.toString());
	}
	@Override
	protected Typename chequea() {
		// check si o1 es reg, se supone que arriba
		return acc.tipo().pure();
	}
	public String o2() {
		return o2.toString();
	}
}
