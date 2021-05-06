package ast;

public class EIndice extends EBin {
   private E o1;
   private EBasico o2;
   public EIndice(E opnd1, EBasico opnd2, Op oper) {
	   super(opnd1, opnd2, oper);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
	@Override
	protected void vinculo() throws Exception {
		o1.vinculo();
		o2.vinculo();
		String e1 = null;
		if(o1.oper() == Op.BASICO_ID) {
			e1 = ((EBasico) o1).toString();
		}
		else if (o1.oper() == Op.ACCESO) {
			
		}
		else throw new Exception("Error en vínculo de acceso.");
		if(o2.oper() != Op.BASICO_ID)
			throw new Exception("Error en vínculo de acceso.");
		Reg r = (Reg) Program.buscaId(e1);
		if(r.get(o2.toString())==null)
			throw new Exception("Error en vínculo de acceso: " + o2.toString());
	}
	@Override
	protected String chequea() {
		
		return null;
	}
	public String o2() {
		return o2.toString();
	}
}
