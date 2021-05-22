package ast;

public class EIndice extends EBin {
   private E o1;
   private E o2;
   public EIndice(E opnd1, E opnd2, Op oper, int fila) {
	   super(opnd1, opnd2, oper,fila);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
   private Declare array;
   int dim = 1;
	@Override
	protected void vinculo() throws Exception {
		o2.vinculo();
		if(!Asigna.designable(o1))			
			throw new Exception("Fila " + fila + ". Index no asignable: "+ o1.toString());

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
		else if (o1.oper()==Op.PUNTERO) {
			EPunt o11 = (EPunt) o1;
			o11.vinculo();		
		}
	}
	@Override
	protected Typename chequea() throws Exception {
		Typename s1 = o1.chequea().pure();
		Typename s2 = o2.chequea().pure();
		if(s2.t != Type.ENT)
			throw new Exception("Fila " + fila + ". Index no entero");
		
		if(s1.t != Type.ARR)
			throw new Exception("Fila " + fila + ". Index no array");
		tipo= s1.t_arr.pure();
		return tipo;
	}
	public String o2() {
		return o2.toString();
	}
}
