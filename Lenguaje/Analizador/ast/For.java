package ast;

import alex.TV;

public class For extends Instr {
	private ForDec elemDec;
	private E arr;
	private Instructions lista;
	public For(TV elem, E arr, Instructions d) {
		this.elemDec=new ForDec(elem,this);
		this.arr=arr;
		lista=d;
	}
	public String toString() {
		String sol =  "for (" + elemDec.toString() + " : " + arr.toString();
		sol = sol +  ") {\n" + (lista==null?"":lista.toString())+ "}";  
		return sol;
	}
	@Override
	protected void vinculo() throws Exception {
		arr.vinculo();
		Program.abreBloque();
		Program.insertaId(elemDec.toString(), elemDec); // turbio
		lista.vinculo();
		Program.cierraBloque();
	}
	@Override
	protected void chequea() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
