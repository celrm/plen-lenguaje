package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Param extends Declare {
	Typename tipo;
	private TV id;
	int tam = 1;
	public Param(Typename tipo, TV id) {
		super(id.fila);
		this.tipo = tipo;
		this.id = id;
		type_of_dec = Dec.PARAM;
	}
	public String toString() {
		String sol = tipo.toString() + " ";
		sol = sol + id.toString();
		return (isconst?"const " :"") + sol;
	}
	public void vinculo() throws Exception {
		if(name().equals("length") || name().equals("kin")) {
			throw new Exception("Fila " + fila + ". Banned word: "+ name());
		}
		Typename.check_custom(tipo,fila);
		Program.insertaId(id.toString(), this);
	}
	protected String name() {
		return id.toString();
	}
	@Override
	protected List<Typename> chequea() {
		return new ArrayList<>();}
	@Override
	protected Typename tipo() {
		return tipo;
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max) {
		this.delta = c.v;
		c.v += tipo.shape.v;
		if (c.v > max.v) max.v = c.v; 
	}
	@Override
	protected String codigo() {
		// TODO Auto-generated method stub
		return null;
	}
	public String size() {
		return "i32.const "+tipo.shape.v*4+"\n";
	}
}
