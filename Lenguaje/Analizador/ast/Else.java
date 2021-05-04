package ast;

public class Else extends Instr {
	private Instructions lista;
	public Else(Instructions d) {
		lista=d;
	}
	public String toString() {
		return "else {\n" + (lista==null?"":lista.toString())+ "}";  
	}
	@Override
	protected void vinculo() throws Exception {
		Program.abreBloque();
		lista.vinculo();
		Program.cierraBloque();
	}
	@Override
	protected void chequea() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
