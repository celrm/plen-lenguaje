package ast;

public class EPuntInv extends E {
   private E o1;
   public EPuntInv(E opnd1, Op oper, int fila) {
	   super(oper, fila);
	     this.o1 = opnd1;
   }
	@Override
	protected void vinculo() throws Exception {
		o1.vinculo();
	}
	@Override
	protected Typename chequea() throws Exception {
		Typename t = o1.chequea().pure();
		tipo= new Typename(t,Type.PUNT);
		if(!Asigna.designable(o1))
			throw new Exception("Fila " + fila + ". No designable: " + o1.toString());
		return tipo;
	}
	@Override
	public String toString() {
		return this.oper().toString() + " " + o1.toString();
	}
	@Override
	protected String codigoE() {
		return o1.codigoD();
	}
	@Override
	protected String codigoD() {
		// TODO Auto-generated method stub
		return null;
	}
}
