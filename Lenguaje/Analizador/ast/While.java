package ast;

public class While extends Instr {
	private E b;
	private Instructions lista;
	public While(E b, Instructions d) {
		this.b=b;
		lista=d;
	}
	public String toString() {
		String sol = "while ("+ b.toString()  +") {\n";
		sol = sol+(lista==null?"":lista.toString())+ "}";
		return sol;
	}
}
