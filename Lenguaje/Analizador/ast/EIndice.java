package ast;

public class EIndice extends E {
   private E o1;
   private E o2;
   public EIndice(E opnd1, E opnd2, Op oper, int fila) {
	   super(oper,fila);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
//   Declare d;
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
		}
		else if (o1.oper()==Op.PUNTERO) {
			EPunt o11 = (EPunt) o1;
			o11.vinculo();
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
	@Override
	protected String codigoE() { // no para punteros
		String sol = codigoD()
				+ "i32.load\n";
		
		return sol;
	}
	@Override
	protected String codigoD() {
		// TODO Auto-generated method stub
		return 
		"	;; Base direction "+o1+"\n"+
		o1.codigoD() +"\n"+
		"	;; Element size "+o1+"\n"+
		 "i32.const " + tipo.shape+" \n"+
		"	;; Index "+o2+"\n"+
		 o2.codigoE()+
		 "i32.mul\n"+
		"	;; Size*Index \n"+
		 "i32.const 4\n"+
		 "i32.mul\n"+
		"	;; Typical * 4 \n"+
		 "i32.add\n";
	}
}
