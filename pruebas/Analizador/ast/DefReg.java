package ast;

import alex.TV;

public class DefReg extends Declare {
	private TV id;
	private Params params;
	private Declares decs;
	public DefReg(TV id, Params params, Declares d) {
		type_of_dec=Dec.REGISTER;
		this.id=id;
		this.params=params;
		decs=d;
	}
	public String toString() {
		String sol = "data " + id.toString();
		sol = sol + " (" + (params==null?"":params.toString()) + ") {\n";
		sol = sol + (decs==null?"":decs.toString()) + "}";
		return sol;
	}
}
