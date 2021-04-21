package exp;

import ast.Tipo;
import sem.SemArray;
import sem.SemBul;
import sem.SemEnt;
import sem.Semantic;

public class ArrayInit extends EBin {
   public ArrayInit(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public String toString() {
	   return "array_init("+opnd1().toString()+","+opnd2().toString()+")";
	}
   public Semantic valor() {
	   SemEnt v1 = (SemEnt) (opnd1().valor());
	   Semantic v2 = (Semantic) (opnd2().valor());
	   return new SemArray(v1,v2);
   }
   public Tipo tipo() {
	   return opnd2().tipo();
   }
}
