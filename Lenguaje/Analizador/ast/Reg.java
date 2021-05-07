package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Reg extends Declare {
	private Typename tipo;
	private TV id;
	private HeterValues v;
	public Reg(Typename tipo, TV id, HeterValues values) {
		this.tipo=tipo;
		this.id=id;
		this.v=values;
		type_of_dec=Dec.DEFREG;
		type_of_in = In.DECLARE;
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
		dr = (DefReg) Program.buscaId(tipo.toString());
		Program.insertaId(name(), this);
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		while(true) {
			Params p = dr.params;
			HeterValues q = v;
			if(p==null && q == null)
				return new ArrayList<>();
			if(p==null || q == null)
				throw new Exception("different parameters in call "+id.fila);
			Param e1 = p.p;
			p = p.rest;
			E e2 = v.e;
			v = v.rest;
			e1.chequea();
			Typename par = e2.chequea();
			if(!e1.tipo().equals(par)) {
				throw new Exception("different parameter types in call "+id.fila);
			}
		}
	}
	public Object get(String arg0) {
		return dr.get(arg0);
	}
	@Override
	protected Typename tipo() {
		return tipo;
	}
}
