package ast;

public class ElseIf extends Instr {
	private E b;
	private Instructions lista;
	public ElseIf(E b, Instructions d) {
		this.b=b;
		lista=d;
	}
	public String toString() {
		String sol = "else if ("+ b.toString()  +") {\n";
		sol = sol+(lista==null?"":lista.toString()) + "}";
		return sol;
	}
	@Override
	protected void vinculo() throws Exception {
		b.vinculo();
		Program.abreBloque();
		lista.vinculo();
		Program.cierraBloque();
	}
	@Override
	protected void chequea() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
