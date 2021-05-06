package ast;

import alex.TV;

public class Call extends E {	
	TV id;
	HeterValues v; // puede ser null
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
	protected String chequea() {
		// TODO comprobar parámetros
		return f.tipo().pure();
	}
}
