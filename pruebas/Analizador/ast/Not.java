package ast;

public class Not extends EMono {
	public Not(E opn) {
	     super(opn);  
	}
	   public String toString() {return "not("+opnd1()+")";}

}
