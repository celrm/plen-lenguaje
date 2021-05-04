package ast;

import alex.TV;

public class For extends Instr {
	private TV elem;
	private E arr;
	private Instructions lista;
	public For(TV elem, E arr, Instructions d) {
		this.elem=elem;
		this.arr=arr;
		lista=d;
	}
	public String toString() {
		String sol =  "for (" + elem.toString() + " : " + arr.toString();
		sol = sol +  ") {\n" + (lista==null?"":lista.toString())+ "}";  
		return sol;
	}
	@Override
	protected void vinculo() throws Exception {
		arr.vinculo();
		Program.abreBloque();
		Program.insertaId(elem.toString(), this);
		lista.vinculo();
		Program.cierraBloque();
	}
	@Override
	protected void chequea() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
