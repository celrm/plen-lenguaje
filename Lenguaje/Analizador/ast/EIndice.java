package ast;

public class EIndice extends EBin {
   private E o1;
   private E o2;
   public EIndice(E opnd1, E opnd2, Op oper, int fila) {
	   super(opnd1, opnd2, oper,fila);
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
	protected Typename chequea() throws Exception {
		Typename s1 = o1.chequea();
		Typename s2 = o2.chequea();
		if(s2.t != Type.ENT)
			throw new Exception("Acceso no entero");
		
		if(s1.t != Type.ARR)
			throw new Exception("Acceso no array");
		return s1.t_arr;
	}
	public String o2() {
		return o2.toString();
	}
}
