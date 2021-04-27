package ast;

public class Asigna extends Instr {

	private E e1;
	private E e2;

	public Asigna(E e1, E e2) {
		this.e1=e1;
		this.e2=e2;
	}
	public String toString() {
		return "("+e1.toString() + ")=(" + e2.toString() + ").";
	}
}
