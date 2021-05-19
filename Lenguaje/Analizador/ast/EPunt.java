package ast;

public class EPunt extends EMono {
   private E o1;
   public EPunt(E opnd1, Op oper, int fila) {
	   super(opnd1, oper, fila);
	     this.o1 = opnd1;
   }
	@Override
	protected void vinculo() throws Exception {
		o1.vinculo();
	}
	@Override
	protected Typename chequea() throws Exception {
		Typename t = o1.chequea().pure();
		if(t.t != Type.PUNT)
			throw new Exception("Fila " + fila + ". No es puntero: "+ o1.toString());
		return t.t_arr.pure();
	}
}
