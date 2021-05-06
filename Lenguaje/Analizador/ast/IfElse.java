package ast;

public class IfElse extends Instr {
	private E b;
	private Instructions listaif;
	private Instructions listaelse;
	public IfElse(E b, Instructions d1, Instructions d2) {
		this.b=b;
		listaif=d1;
		listaelse=d2;
		type_of_in = In.IFELSE;
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
		String s = b.chequea();
		if(!s.equals("bul")) {
			throw new Exception("Ifelse no bul b");
		}
		listaif.chequea();
		listaelse.chequea();
	}
}
