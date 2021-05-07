package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class DefFun extends Declare {
	private TV id;
	private Typename tipo;
	Params params;
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
	protected List<Typename> chequea() throws Exception {
		Typename t = tipo.pure();
		List<Typename> returns = decs.chequea();
		for(Typename ret : returns) {
			if(!ret.equals(t))
				throw new Exception("Bad return type: "+ t + " / " + ret);
		}
		return new ArrayList<>();
	}
	public Typename tipo() {
		return tipo;
	}
}
