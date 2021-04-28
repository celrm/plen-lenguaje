package ast;

public class Kut extends Instr {
	private E print;
	public Kut(E i) {
		print=i;
	}
	public String toString() {
		return "kut("+print.toString()+").";
	}
}
