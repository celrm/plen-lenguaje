package ast;

import alex.TV;

public class DefFun extends Declare {
	private TV id;
	private Typename tipo;
	private Params params;
	private Instructions decs;
	public DefFun(TV id, Typename tipo, Params params, Instructions d) {
		type_of_dec = Dec.FUNCTION;
		this.id=id;
		this.tipo=tipo;
		this.params=params;
		this.decs=d;
	}
	public String toString() {
		String sol = "function " + id.toString() + " return " + tipo.toString();
		sol = sol + " (" + (params==null?"":params.toString()) + ") {\n";
		sol = sol + (decs==null?"":decs.toString()) + "}";
		return sol;
	}
	@Override
	protected void vinculo() throws Exception {
		Program.insertaId(id.toString(), this);
		Program.abreBloque();
		
		params.vinculo();
		decs.vinculo();
		
		Program.cierraBloque();
	}
	@Override
	protected void chequea() {
		// TODO Auto-generated method stub
		
	}
	public Typename tipo() {
		return tipo;
	}
}
