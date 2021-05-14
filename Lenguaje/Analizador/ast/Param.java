package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Param extends Declare {
	private Typename tipo;
	private TV id;
	boolean is_const=false;
	public Param(Typename tipo, TV id) {
		super(id.fila);
		this.tipo = tipo;
		this.id = id;
		type_of_dec = Dec.PARAM;
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
	protected List<Typename> chequea() {
		return new ArrayList<>();}
	@Override
	protected Typename tipo() {
		return tipo;
	}
}
