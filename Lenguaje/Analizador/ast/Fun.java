package ast;

public class Fun extends Instr {
	private Call f;
	public Fun(Call f) {
		this.f=f;
	}
	public String toString() {
		return f.toString() + ".";
	}
}
