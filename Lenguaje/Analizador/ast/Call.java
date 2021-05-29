package ast;

import alex.TV;

public class Call extends E {	
	TV id;
	HeterValues v;
	public Call(TV id, HeterValues v, int fila) {
		super(Op.CALL,fila);
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
		f = (DefFun) Program.buscaId(id.toString(),fila);
		
		Params p = f.params;
		HeterValues q = v;
		while(true) {
			if(p==null && q == null)
				return;
			if(q==null)
				throw new Exception("Fila " + fila + ". Different parameters p: "+p.toString()+" in call");
			if(p==null)
				throw new Exception("Fila " + fila + ". Different parameters c: "+q.toString()+" in call");
			
			q.p = p.p;
			
			p = p.rest;
			q = q.rest;
		}
	}
	@Override
	protected Typename chequea() throws Exception {
		HeterValues q = v;
		while(q != null) {
			Param e1 = q.p;
			E e2 = q.e;
			e1.chequea();
			Typename pt = e1.tipo.pure();
			Typename et = e2.chequea().pure();
			if(!pt.equals(et) && !id.lexema.equals("length")) {
				throw new Exception("Fila " + fila + ". Different parameter types in call");
			}
			e1.tipo = e2.tipo;		

			q = q.rest;
		}
		tipo = f.tipo().pure();
		return tipo;
	}
	@Override
	protected String codigoE() {
		return (v==null?"":v.codigo(2)) + 
				"\n" + 
				"call $_"+
				id.toString()+
				"\n";
	}
	@Override
	protected String codigoD() {
		// TODO Auto-generated method stub
		return null;
	}
}
