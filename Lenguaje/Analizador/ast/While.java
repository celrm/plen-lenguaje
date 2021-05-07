package ast;

public class While extends Instr {
	private E b;
	private Instructions lista;
	public While(E b, Instructions d) {
		this.b=b;
		lista=d;
		type_of_in = In.WHILE;
	}
	public String toString() {
		String sol = "while ("+ b.toString()  +") {\n";
		sol = sol+(lista==null?"":lista.toString())+ "}";
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
		Typename s = b.chequea();
		if(s.t != Type.BUL) {
			throw new Exception("While no bul b");
		}
		lista.chequea();
	}
}
