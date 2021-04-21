package ast;

public class Distinto extends EBin {
   public Distinto(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public String toString() {return "distinto("+opnd1().toString()+","+opnd2().toString()+")";}
}
