package ast;

import alex.TV;

public class Reg extends Declare {
	private Typename tipo;
	private TV id;
	private HeterValues values;
	public Reg(Typename tipo, TV id, HeterValues values) {
		this.tipo=tipo;
		this.id=id;
		this.values=values;
		type_of_dec=Dec.DEFREG;
	}
	public String toString() {
		String sol = tipo.toString() + " ";
		sol = sol + id.toString() + " (";
		sol = sol + (values==null?"":values.toString())+ ").";
		return sol;
	}
}
