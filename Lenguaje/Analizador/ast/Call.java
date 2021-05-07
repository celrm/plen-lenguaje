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
		if(v!=null) {
			v.vinculo();
		}
		f = (DefFun) Program.buscaId(id.toString()); // CAST
	}
	@Override
	protected Typename chequea() throws Exception {
		Params p = f.params;
		HeterValues q = v;
		while(true) {
			if(p==null && q == null)
				return f.tipo().pure();
			if(q==null)
				throw new Exception("different parameters p: "+p.toString()+" in call "+id.fila);
			if(p==null)
				throw new Exception("different parameters c: "+q.toString()+" in call "+id.fila);
			Param e1 = p.p;
			p = p.rest;
			E e2 = q.e;
			q = q.rest;
			e1.chequea();
			Typename par = e2.chequea();
			if(!e1.tipo().equals(par)) {
				throw new Exception("different parameter types in call "+id.fila);
			}
		}
	}
}
