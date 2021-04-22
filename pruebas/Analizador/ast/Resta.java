package ast;

public class Resta extends EBin {
   public Resta(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public String toString() {return "suma("+opnd1().toString()+","+opnd2().toString()+")";}
}
