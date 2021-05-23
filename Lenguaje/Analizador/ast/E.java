package ast;

public abstract class E {
	private Op oper;
	int fila;
	Typename tipo;
	public E(Op oper, int fila) {
		this.oper=oper;
		this.fila = fila;
	}
	public Op oper() {
		return oper;
	}
	public abstract String toString();
	protected abstract void vinculo() throws Exception;
	protected abstract Typename chequea() throws Exception;
	protected abstract String codigoE();
	protected abstract String codigoD();
}