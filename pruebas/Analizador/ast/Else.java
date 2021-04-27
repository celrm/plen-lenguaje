package ast;

public class Else extends Instr {
	private Instructions lista;
	public Else(Instructions d) {
		lista=d;
	}
	public String toString() {
		return "else {\n" + lista.toString() + "}";  
	}
}
