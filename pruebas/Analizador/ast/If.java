package ast;

public class If extends Instr {
	private E b;
	private Instructions lista;
	public If(E b, Instructions d) {
		this.b=b;
		lista=d;
	}
	public String toString() {
		String sol = "if ("+ b.toString()  +") {\n";
		sol = (lista==null?"":lista.toString())+ "}";
		return sol;
	}
}
