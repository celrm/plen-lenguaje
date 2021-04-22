package ast;

public class Indice extends EBin {
	public Indice(E opnd1, E opnd2) {
	     super(opnd1,opnd2);  
	} 
	   public String toString() {return "indice("+opnd1().toString()+","+opnd2().toString()+")";}

}
