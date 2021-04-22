package ast;

public class Acceso extends EBin {
	public Acceso(E opnd1, E opnd2) {
	     super(opnd1,opnd2);  
	}
	   public String toString() {
		   return "acceso("+opnd1().toString()+","+opnd2().toString()+")";
		}
//	   public Semantic valor() {
//		   SemRegistro v1 = (SemRegistro) (opnd1().valor());
//		   SemID v2 = (SemID) (opnd2().valor());
//		   return v1.search(v2);
//	   }
//	   public Tipo tipo() {
//		   return opnd2().tipo();
//	   }
}
