package ast;

public abstract class E {
	private Op oper;
	public E(Op oper) {
		this.oper=oper;
	}
	public Op oper() {
		return oper;
	}
	public abstract String toString();
}
