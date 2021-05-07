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
		type_of_in = In.FOR;
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
		Typename s1 = arr.chequea(); 

		if(s1.t != Type.ARR)
			throw new Exception("Acceso no array");
		elemDec.tipo = s1.t_arr;
		lista.chequea();
	}
}
