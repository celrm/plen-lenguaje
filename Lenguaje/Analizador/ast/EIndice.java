package ast;

public class EIndice extends E {
   private E o1;
   private E o2;
   public EIndice(E opnd1, E opnd2, Op oper, int fila) {
	   super(oper,fila);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
   Declare d;
   int dim = 1;
	@Override
	protected void vinculo() throws Exception {
		o2.vinculo();
	
		if (o1.oper()==Op.BASICO_ID) {		
			EBasico o11 = (EBasico) o1;
			o11.vinculo();
//			d = o11.d;
		}
		else if (o1.oper()==Op.ACCESO) {
			EAcceso o11 = (EAcceso) o1;
			o11.vinculo();
//			d = o11.acc;
		}
		else if (o1.oper()==Op.INDICE) {
			EIndice o11 = (EIndice) o1;
			o11.vinculo();
//			d = o11.d;
//			dim = o11.dim+1;
		}
		else if (o1.oper()==Op.PUNTERO) {
			EPunt o11 = (EPunt) o1;
			o11.vinculo();
//			d = o11.d; TODO
		}

		if(!Asigna.designable(o1))			
			throw new Exception("Fila " + fila + ". Index no asignable: "+ o1.toString());

	}
	@Override
	protected Typename chequea() throws Exception {
		Typename s1 = o1.chequea();
		Typename s2 = o2.chequea().pure();
		if(s2.t != Type.ENT)
			throw new Exception("Fila " + fila + ". Index no entero");
		
		if(s1.t != Type.ARR)
			throw new Exception("Fila " + fila + ". Index no array");
		
		tipo = s1.t_arr.pure();		
		return tipo;
	}
	public String o2() {
		return o2.toString();
	}
	public String toString() {
		return "("+o1.toString() + " " + this.oper().toString() + " " + o2.toString()+")";
	}
	protected String getref() {
		return  Asigna.design(o1) +"\n"
					+ "i32.const " +tipo.size()+" \n"
					+ o2.codigo()
					+ "i32.mul\n"
					+ "i32.const 4\n"
					+ "i32.mul\n"
			+ "i32.add\n";
	}
	@Override
	protected String codigo() { // no para punteros
		String sol = getref()
				+ "i32.load\n";
		
		return sol;
	}
}
