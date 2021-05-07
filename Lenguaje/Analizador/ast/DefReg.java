package ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alex.TV;

public class DefReg extends Declare {
	private TV id;
	Params params;
	private Instructions ins;
	public DefReg(TV id, Params params, Instructions d) {
		type_of_dec=Dec.REGISTER;
		this.id=id;
		this.params=params;
		ins=d;
		type_of_in = In.DECLARE;
	}
	public String toString() {
		String sol = "data " + id.toString();
		sol = sol + " (" + (params==null?"":params.toString()) + ") {\n";
		sol = sol + (ins==null?"":ins.toString()) + "}";
		return sol;
	}
	private Map<String,Object> defs;
	public String name() {
		return id.toString();
	}
	@Override
	protected void vinculo() throws Exception {
		Program.insertaId(name(), this);
		Program.abreBloque();
		
		if(params!=null)
			params.vinculo();
		
		Program.abreBloque();
		if(ins!=null)
			ins.vinculo();
		defs = Program.paraRegistros();
		Program.cierraBloque();
		
		Program.cierraBloque();
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		ins.chequea();
		return new ArrayList<>();
	}
	public Object get(String arg0) {
		return defs.get(arg0);
	}
	@Override
	protected Typename tipo() {
		return new Typename(id);
	}
}
