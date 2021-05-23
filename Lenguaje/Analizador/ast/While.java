package ast;

import java.util.ArrayList;
import java.util.List;

public class While extends Instr {
	private E b;
	private Instructions lista;
	public While(E b, Instructions d) {
		super(b.fila);
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
		if(lista!=null)	
			lista.vinculo();
		Program.cierraBloque();
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		Typename s = b.chequea().pure();
		if(s.t != Type.BUL) {
			throw new Exception("Fila " + fila + ". While no bul b");
		}
		if(lista!=null)
			return lista.chequea();
		return new ArrayList<>();
	}
	boolean siesbloque = true;
	@Override
	public void maxMemory(WrapInt c, WrapInt max) {
		if (siesbloque) { // isBlock()
			siesbloque = false;
			WrapInt c1 = new WrapInt();
			WrapInt max1 = new WrapInt();
			c1.v = c.v;
			max1.v = max.v;
			maxMemory(c1,max1);
			if (c.v+max1.v > max.v) {
				max.v = c.v + max1.v;
			}
		} else {
		if(lista!=null)
			lista.maxMemory(c,max);
		}
	}
	@Override
	protected String codigo() {
		String codeI = "";
		if(lista!=null)
			codeI = lista.codigo();
		String sol = 
				"	(block\n" +
				"   (loop\n"+
				b.codigoE() +
				"	i32.eqz\n"+
				"	br_if 1\n"+
				codeI +
				"	br 0\n"+
				"	))\n"
				;

		return sol;
	}
}
