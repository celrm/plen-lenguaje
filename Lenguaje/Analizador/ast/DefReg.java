package ast;

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
}
