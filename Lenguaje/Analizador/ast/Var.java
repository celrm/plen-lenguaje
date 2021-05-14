package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Var extends Declare {
	private Typename type;
	private TV id;
	private E exp;
	private boolean is_const;
	public Var(Typename tipo, TV id, E exp2, boolean is_const) {
		super(id.fila);
		this.type=tipo;
		this.id=id;
		this.exp=exp2;
		this.is_const=is_const;
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
	protected List<Typename> chequea() throws Exception {
		Typename t = type.pure();
		Typename e = exp.chequea();
		if(!t.equals(e)) {
			throw new Exception("bad var declare " + t +" " + e+" "+ id.fila);
		}
		return new ArrayList<>();
	}
	@Override
	protected Typename tipo() {
		return type;
	}
}
