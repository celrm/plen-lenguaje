package exp;

public class Meq extends EBin {
   public Meq(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public String toString() {return "meq("+opnd1().toString()+","+opnd2().toString()+")";}
}