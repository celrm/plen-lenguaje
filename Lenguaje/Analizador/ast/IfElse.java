package ast;

import java.util.ArrayList;
import java.util.List;

public class IfElse extends Instr {
	private E b;
	private Instructions listaif;
	private Instructions listaelse;
	public IfElse(E b, Instructions d1, Instructions d2) {
		super(b.fila);
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
		if(listaif!=null)
		listaif.vinculo();
		Program.cierraBloque();
		Program.abreBloque();
		if(listaelse!=null)
		listaelse.vinculo();
		Program.cierraBloque();
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		Typename s = b.chequea().pure();
		if(s.t != Type.BUL) {
			throw new Exception("Fila " + fila + ". Ifelse no bul b");
		}
		List<Typename> rets1, rets2;
		if(listaif!=null)
			rets1= listaif.chequea();
		else 
			rets1= new ArrayList<>();
		if(listaelse!=null)
			rets2= listaif.chequea();
		else 
			rets2= new ArrayList<>();		
		rets1.addAll(rets2);
		return rets1;
	}
	boolean siesbloque = true;
	boolean siesbloque2 = true;
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
		} else if (siesbloque2) { // isBlock()

			siesbloque2 = false;
			WrapInt c1 = new WrapInt();
			WrapInt max1 = new WrapInt();
			c1.v = c.v;
			max1.v = max.v;
			
			listaif.maxMemory(c,max);
			
			maxMemory(c,max);
			
			maxMemory(c1,max1);
			if (c.v+max1.v > max.v) {
				max.v = c.v + max1.v;
			}
		} else {
			listaelse.maxMemory(c,max);
		}
	}
	@Override
	protected String codigo() {
		String codeI = "";
		String codeII = "";
		if(listaif!=null)
			codeI = listaif.codigo();
		if(listaelse!=null)
			codeII = listaelse.codigo();
		return 
				b.codigoE() +
				"   if\n"+
				codeI +
				"   else\n"+
				codeII +
				"	end\n"
				;
	}
}
