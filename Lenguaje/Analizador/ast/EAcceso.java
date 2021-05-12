package ast;

public class EAcceso extends EBin {
   private E o1;
   private EBasico o2;
   public EAcceso(E opnd1, EBasico opnd2, Op oper) {
	   super(opnd1, opnd2, oper);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
   Declare r; 
   DefReg dr;
   Declare acc;
	@Override
	protected void vinculo() throws Exception {		
		if (o1.oper()==Op.BASICO_ID) {
			r = (Declare) Program.buscaId(o1.toString());
		}
		else if (o1.oper()==Op.ACCESO) {
			EAcceso o11 = (EAcceso) o1;
			o11.vinculo();
			r = o11.acc;
		}
		else 
			throw new Exception("Access: "+ o2.toString());
		

		Typename t = r.tipo();
		if (t.t != Type.CUSTOM)
			throw new Exception("Access: "+ r.toString());
		
		dr = (DefReg) Program.buscaId(t.pure().toString()); // este es mi problema
		// no puedo poner buscaid en chequea porque no estarán los ámbitos activos
		// no puedo poner pure antes de haber preprocesado... -> prechequea al principio...

	}
	@Override
	protected Typename chequea() throws Exception {
		if(o2.oper()!=Op.BASICO_ID)
			throw new Exception("Access: "+ o2.toString());
		
		acc = (Declare) dr.get(o2.toString());
		return acc.tipo().pure();
	}
	public String o2() {
		return o2.toString();
	}
}
