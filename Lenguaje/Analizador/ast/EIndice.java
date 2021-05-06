package ast;

public class EIndice extends EBin {
   private E o1;
   private E o2;
   public EIndice(E opnd1, E opnd2, Op oper) {
	   super(opnd1, opnd2, oper);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
   Declare array;
   int dim = 1;
	@Override
	protected void vinculo() throws Exception {
		if (o1.oper()==Op.BASICO_ID) {
			EBasico o11 = (EBasico) o1;
			o11.vinculo();
			array = o11.d;
		}
		else if (o1.oper()==Op.ACCESO) {
			EAcceso o11 = (EAcceso) o1;
			o11.vinculo();
			array = o11.acc;
		}
		else if (o1.oper()==Op.INDICE) {
			EIndice o11 = (EIndice) o1;
			o11.vinculo();
			array = o11.array;
			dim = o11.dim+1; 
		}
		else 
			throw new Exception("Access: "+ o2.toString());
	}
	@Override
	protected String chequea() throws Exception {
		String s1 = o1.chequea();
		String s2 = o2.chequea();
		if(!s2.equals("ent"))
			throw new Exception("Acceso no entero");
		
		if(!s1.startsWith("arr\\"))
			throw new Exception("Acceso no array");
		return s1.substring(4);
	}
	public String o2() {
		return o2.toString();
	}
}
