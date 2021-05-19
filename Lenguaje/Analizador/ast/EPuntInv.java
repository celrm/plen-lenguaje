package ast;

public class EPuntInv extends EMono {
   private E o1;
   public EPuntInv(E opnd1, Op oper, int fila) {
	   super(opnd1, oper, fila);
	     this.o1 = opnd1;
   }
	@Override
	protected void vinculo() throws Exception {
		o1.vinculo();
	}
	@Override
	protected Typename chequea() throws Exception {
		if(!Asigna.designable(o1))
			throw new Exception("Fila " + fila + ". No designable: " + o1.toString());
		Typename t = o1.chequea().pure();
		return new Typename(t,Type.PUNT);
	}
}
