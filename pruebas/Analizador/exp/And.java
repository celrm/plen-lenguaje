package exp;

import ast.Tipo;
import sem.SemBul;
import sem.SemID;
import sem.SemRegistro;
import sem.Semantic;

public class And extends EBin {
   public And(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public String toString() {
	   return "and("+opnd1().toString()+","+opnd2().toString()+")";
	}
   public Semantic valor() {
	   SemBul v1 = (SemBul) (opnd1().valor());
	   SemBul v2 = (SemBul) (opnd2().valor());
	   return v1.and(v2);
   }
   public Tipo tipo() {
	   return Tipo.Bul;
   }
}
