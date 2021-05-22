package ast;

import java.util.List;

import alex.TV;

public class For extends Instr {
	private ForDec elemDec;
	private E arr;
	private Instructions lista;
	public For(TV elem, E arr, Instructions d) {
		super(arr.fila);
		this.elemDec=new ForDec(elem,this,arr.fila);
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
	protected List<Typename> chequea() throws Exception {
		Typename s1 = arr.chequea().pure();

		if(s1.t != Type.ARR)
			throw new Exception("Fila " + fila + ". Acceso no array");
		elemDec.tipo = s1.t_arr.pure();
		return lista.chequea();
	}
	boolean siesbloque = true;
	@Override
	public void maxMemory(WrapInt c, WrapInt max, WrapInt delta) {
		if (siesbloque) { // isBlock()
			siesbloque = false;
			WrapInt c1 = new WrapInt();
			WrapInt max1 = new WrapInt();
			WrapInt delta1 = new WrapInt();
			maxMemory(c1,max1,delta1);
			if (c.v+max1.v > max.v) {
				max.v = c.v + max1.v;
			}
		} else {
		if(lista!=null)
			lista.maxMemory(c,max,delta);
		}
	}
	@Override
	protected String codigo() {
		// TODO Auto-generated method stub
		return null;
	}

}