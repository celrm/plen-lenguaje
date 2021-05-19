package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Var extends Declare {
	private Typename tipo;
	private TV id;
	private E exp;
	private boolean is_const;
	public Var(Typename tipo, TV id, E exp2, boolean is_const) {
		super(id.fila);
		this.tipo=tipo;
		this.id=id;
		this.exp=exp2;
		this.is_const=is_const;
	}
	public String toString() {
		String sol = tipo.toString() + " ";
		sol = sol + id.toString() + " = ";
		sol = sol + exp.toString() + ".";
		return (is_const?"const " :"") + sol;
	}
	@Override
	protected void vinculo() throws Exception {
		if(name().equals("length") || name().equals("kin")) {
			throw new Exception("Fila " + fila + ". Banned word: "+ name());
		}
		Typename.check_custom(tipo,fila);
		exp.vinculo();
		Program.insertaId(id.toString(), this);
	}
	protected String name() {
		return id.toString();
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		Typename t = tipo.pure();
		Typename e = exp.chequea().pure();
		if(!t.equals(e)) {
			throw new Exception("Fila " + fila + ". Bad var declare " + t +" " + e+" "+ id.fila);
		}
		return new ArrayList<>();
	}
	@Override
	protected Typename tipo() {
		return tipo;
	}
}
