package ast;

import alex.TV;

public class Call extends E {	
	TV id;
	HeterValues v;
	public Call(TV id, HeterValues v) {
		super(Op.CALL);
		this.id = id;
		this.v = v;
	}
	public String toString() {
		String sol = id.toString();
		return sol+"("+ (v==null?"":v.toString())  +")";
	}
	DefFun f;
	@Override
	protected void vinculo() throws Exception {
		if(v!=null)
			v.vinculo();
		f = (DefFun) Program.buscaId(id.toString());
	}
	@Override
	protected Typename chequea() throws Exception {
		while(true) {
			Params p = f.params;
			HeterValues q = v;
			if(p==null && q == null)
				return f.tipo().pure();
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
}
