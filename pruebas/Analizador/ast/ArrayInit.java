package ast;

public class ArrayInit extends EBin {
   public ArrayInit(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public String toString() {
	   return "array_init("+opnd1().toString()+","+opnd2().toString()+")";
	}
}
