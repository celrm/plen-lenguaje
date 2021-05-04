package ast;

import java.util.Map;

import alex.TV;

public class DefReg extends Declare {
	private TV id;
	private Params params;
	private Instructions ins;
	public DefReg(TV id, Params params, Instructions d) {
		type_of_dec=Dec.REGISTER;
		this.id=id;
		this.params=params;
		ins=d;
	}
	public String toString() {
		String sol = "data " + id.toString();
		sol = sol + " (" + (params==null?"":params.toString()) + ") {\n";
		sol = sol + (ins==null?"":ins.toString()) + "}";
		return sol;
	}
	private Map<String,Object> defs;
	@Override
	protected void vinculo() throws Exception {
		Program.insertaId(id.toString(), this);
		Program.abreBloque();
		
		params.vinculo();
		
		Program.abreBloque();
		ins.vinculo();
		defs = Program.paraRegistros();
		Program.cierraBloque();
		
		Program.cierraBloque();
	}
	@Override
	protected void chequea() {
		// TODO Auto-generated method stub
		
	}
	public Object get(String arg0) {
		return defs.get(arg0);
	}
}
