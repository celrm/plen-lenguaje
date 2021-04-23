package ast;

public class And extends EBin {
   public And(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public String toString() {
	   return "and("+opnd1().toString()+","+opnd2().toString()+")";
	}
//   public Tipo tipo() {
//	   return Tipo.Bul;
//   }
}
