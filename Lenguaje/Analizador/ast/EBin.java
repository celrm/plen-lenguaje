package ast;

public class EBin extends E {
   private E o1;
   private E o2;
   public EBin(E opnd1, E opnd2, Op oper) {
	   super(oper);
	     this.o1 = opnd1;
	     this.o2 = opnd2;
   }
	public String toString() {
		return "("+o1.toString() + " " + this.oper().toString() + " " + o2.toString()+")";
	}
	@Override
	protected void vinculo() throws Exception {
		o1.vinculo();
		o2.vinculo();
	}
	@Override
	protected String chequea() {
		// TODO Auto-generated method stub
		return null;
	}
}
