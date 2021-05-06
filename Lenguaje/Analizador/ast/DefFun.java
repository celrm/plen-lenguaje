package ast;

import java.util.List;

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
		type_of_in = In.DECLARE;
	}
	public String toString() {
		String sol = "function " + id.toString() + " return " + tipo.toString();
		sol = sol + " (" + (params==null?"":params.toString()) + ") {\n";
		sol = sol + (decs==null?"":decs.toString()) + "}";
		return sol;
	}
	public String name() {
		return id.toString();
	}
	@Override
	protected void vinculo() throws Exception {
		Program.insertaId(name(), this);
		Program.abreBloque();
		
		if(params!=null)
			params.vinculo();
		if(decs!=null)
			decs.vinculo();
		
		Program.cierraBloque();
	}
	@Override
	protected void chequea() throws Exception {
		String t = tipo.pure();
		List<String> returns = decs.chequea();
		for(String ret : returns) {
			if(!ret.equals(t))
				throw new Exception("Bad return type: "+ t + " / " + ret);
		}
	}
	public Typename tipo() {
		return tipo;
	}
}
