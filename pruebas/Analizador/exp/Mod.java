package exp;

public class Mod extends EBin {
	public Mod(E opnd1, E opnd2) {
	     super(opnd1,opnd2);  
	}  
	   public String toString() {return "mod("+opnd1().toString()+","+opnd2().toString()+")";}

}
