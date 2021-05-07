package ast;

import alex.TV;

public class Var extends Declare {
	private Typename type;
	private TV id;
	private E exp;
	private boolean is_const;
	public Var(Typename tipo, TV id, E exp2, boolean is_const) {
		this.type=tipo;
		this.id=id;
		this.exp=exp2;
		this.is_const=is_const;
		type_of_in = In.DECLARE;
	}
	public String toString() {
		String sol = type.toString() + " ";
		sol = sol + id.toString() + " = ";
		sol = sol + exp.toString() + ".";
		return (is_const?"const " :"") + sol;
	}
	@Override
	protected void vinculo() throws Exception {
		exp.vinculo();
		Program.insertaId(id.toString(), this);
	}
	@Override
	protected void chequea() throws Exception {
		Typename t = type.pure();
		Typename e = exp.chequea();
		if(!t.equals(e)) {
			throw new Exception("bad var declare " + t +" " + e+" "+ id.fila);
		}
	}
	@Override
	protected Typename tipo() {
		return type;
	}
}
