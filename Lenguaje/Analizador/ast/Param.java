package ast;

import alex.TV;

public class Param extends Declare {
	private Typename tipo;
	private TV id;
	boolean is_const=false;
	public Param(Typename tipo, TV id) {
		this.tipo = tipo;
		this.id = id;
		type_of_dec = Dec.PARAM;
		type_of_in = In.DECLARE;
	}
	public String toString() {
		String sol = tipo.toString() + " ";
		sol = sol + id.toString();
		return (is_const?"const " :"") + sol;
	}
	public void vinculo() {
		Program.insertaId(id.toString(), this);
	}
	@Override
	protected void chequea() {}
	@Override
	protected Typename tipo() {
		return tipo;
	}
}
