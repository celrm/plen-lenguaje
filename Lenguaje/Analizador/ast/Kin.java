package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Kin extends DefFun {
	private static TV id = new TV("kin", -1);
	private static Typename tipo = new Typename("ent");
	static Params params = new Params(new Typename("*"), new TV("?", -1), null, false);
	private static Instructions decs=null;
	public Kin() {
		super(id,tipo,params,decs);
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
		return new ArrayList<>();
	}
	public Typename tipo() {
		return tipo;
	}
	public String codigo() {
		return "call $read\n";
	}
}
