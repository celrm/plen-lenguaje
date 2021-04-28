package ast;

public class Return extends Instr {
	private E exp;
	public Return(E e) {
		this.exp=e;
	}
	public String toString() {
		return "return " + exp.toString()+".";
	} 

}
