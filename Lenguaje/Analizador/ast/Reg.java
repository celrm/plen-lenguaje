package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Reg extends Declare {
	private Typename tipo;
	private TV id;
	private HeterValues v;
	public Reg(Typename tipo, TV id, HeterValues values) {
		super(id.fila);
		isconst  =true;
		this.tipo=tipo;
		this.id=id;
		this.v=values;
		type_of_dec=Dec.DEFREG;
	}
	public String toString() {
		String sol = tipo.toString() + " ";
		sol = sol + id.toString() + " (";
		sol = sol + (v==null?"":v.toString())+ ").";
		return sol;
	}
	DefReg dr;
	public String name() {
		return id.toString();
	}
	@Override
	protected void vinculo() throws Exception {
		if(name().equals("length") || name().equals("kin")) {
			throw new Exception("Fila " + fila + ". Banned word: "+ name());
		}
		Typename.check_custom(tipo,fila);
		if(v!=null) {
			v.vinculo();
		}
		tipo = tipo.pure();
		dr = (DefReg) Program.buscaId(tipo.toString().toString(),fila);
		Program.insertaId(name(), this);
		
		Params p = dr.params;
		HeterValues q = v;
		while(true) {
			if(p==null && q == null)
				return;
			if(q==null)
				throw new Exception("Fila " + fila + ". Different parameters p: "+p.toString()+" in call "+id.fila);
			if(p==null)
				throw new Exception("Fila " + fila + ". Different parameters c: "+q.toString()+" in call "+id.fila);
			
			q.p = p.p;
			
			p = p.rest;
			q = q.rest;
		}
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		HeterValues q = v;
		while(q != null) {
			Param e1 = q.p;
			E e2 = q.e;
			e1.chequea();
			Typename par = e2.chequea().pure();
			if(!e1.tipo().equals(par)) {
				throw new Exception("Fila " + fila + ". Different parameter types in call "+id.fila);
			}
			q = q.rest;
		}
		return new ArrayList<>();
	}
	public Object get(String arg0) {
		return dr.get(arg0);
	}
	@Override
	protected Typename tipo() {
		return tipo;
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max) {
//		this.delta = c.v;
//		c.v += size();
//		if (c.v > max.v) max.v = c.v; 
	}
//	private Integer size() {
////		return tipo.size(); // no est??
//	}
	@Override
	protected String codigo() {
		// TODO Auto-generated method stub
		return null;
	}
}
