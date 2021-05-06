package ast;

public class IfElse extends Instr {
	private E b;
	private Instructions listaif;
	private Instructions listaelse;
	public IfElse(E b, Instructions d1, Instructions d2) {
		this.b=b;
		listaif=d1;
		listaelse=d2;
	}
	public String toString() {
		String sol = "if (" + b.toString() + ") {\n";
		sol = sol + (listaif==null?"":listaif.toString())+ "}"; 
		sol = sol + "else {\n";
		sol = sol + (listaelse==null?"":listaelse.toString())+ "}";
		return sol;
	}
	@Override
	protected void vinculo() throws Exception {
		b.vinculo();
		Program.abreBloque();
		listaif.vinculo();
		Program.cierraBloque();
		Program.abreBloque();
		listaelse.vinculo();
		Program.cierraBloque();
	}
	@Override
	protected void chequea() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
