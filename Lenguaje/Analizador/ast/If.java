package ast;

import java.util.List;

public class If extends Instr {
	private E b;
	private Instructions lista;
	public If(E b, Instructions d) {
		super(b.fila);
		this.b=b;
		lista=d;
		type_of_in = In.IF;
	}
	public String toString() {
		String sol = "if ("+ b.toString()  +") {\n";
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
	protected List<Typename> chequea() throws Exception {
		Typename s = b.chequea().pure();
		if(s.t != Type.BUL) {
			throw new Exception("Fila " + fila + ". If no bul b");
		}
		return lista.chequea();
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max, WrapInt delta) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected String codigo() {
		String codeB = b.codigo();
		String codeI = lista.codigo();
		String sol = 
				codeB +
				"   if\n"+
				codeI +
				"	end\n"
				;

		return sol;
	}
}
