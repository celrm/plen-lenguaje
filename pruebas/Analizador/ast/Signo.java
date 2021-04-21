package ast;

public class Signo extends EMono {
	public Signo(E opn) {
	     super(opn);  
	}
	   public String toString() {return "neg("+opnd1()+")";}
}
