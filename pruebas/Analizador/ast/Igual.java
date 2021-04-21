package ast;

public class Igual extends EBin {
   public Igual(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public String toString() {return "suma("+opnd1().toString()+","+opnd2().toString()+")";}
}
