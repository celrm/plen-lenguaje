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
		return o1.toString() + " " + this.oper().toString() + " " + o2.toString();
	}
}
