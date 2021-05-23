package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class Var extends Declare {
	private Typename tipo;
	private TV id;
	private E exp;
	public Var(Typename tipo, TV id, E exp2, boolean is_const) {
		super(id.fila);
		this.tipo=tipo;
		this.id=id;
		this.exp=exp2;
		this.isconst=is_const;
	}
	public String toString() {
		String sol = tipo.toString() + " ";
		sol = sol + id.toString() + " = ";
		sol = sol + exp.toString() + ".";
		return (isconst?"const " :"") + sol;
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
		tipo = e;
		return new ArrayList<>();
	}
	@Override
	protected Typename tipo() {
		return tipo.pure();
	}
	@Override
	public String codigo() {
		if(tipo().t == Type.ARR) {
			if(exp.oper() == Op.LISTA) {
				ListInit l = (ListInit) exp;
				return l.codigo(delta,false);
			}
		}
		
		String codeE = exp.codigo();
		// donde se va a guardar
		String sol = 
				"	get_local $localsStart\n" +
				"   i32.const " + delta * 4 + "\n"+
				"	i32.add\n" +
				codeE +
				"i32.store\n"
				;
		return sol;
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max) {
		this.delta = c.v;
		c.v += size();
		if (c.v > max.v) max.v = c.v; 
	}
	private int size() {
		if(tipo().t == Type.ARR) {
			if(exp.oper() == Op.LISTA) {
				ListInit l = (ListInit) exp;
				return l.tam*tipo().size();
			}
		}
		return tipo().size(); // no está
	}
}
