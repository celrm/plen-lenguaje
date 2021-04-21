package ast;

public class Acceso extends EBin {
	public Acceso(E opnd1, E opnd2) {
	     super(opnd1,opnd2);  
	}
	   public String toString() {
		   return "acceso("+opnd1().toString()+","+opnd2().toString()+")";
		}
}
