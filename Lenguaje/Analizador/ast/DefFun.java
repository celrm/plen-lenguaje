package ast;

import java.util.ArrayList;
import java.util.List;

import alex.TV;

public class DefFun extends Declare {
	private TV id;
	private Typename tipo;
	Params params;
	private Instructions decs;
	static boolean banned = false;
	public DefFun(TV id, Typename tipo, Params params, Instructions d) {
		super(id.fila);
		this.isconst = true;
		type_of_dec = Dec.FUNCTION;
		this.id=id;
		this.tipo=tipo;
		this.params=params;
		this.decs=d;
	}
	public String toString() {
		String sol = "function " + id.toString() + " return " + tipo.toString();
		sol = sol + " (" + (params==null?"":params.toString()) + ") {\n";
		sol = sol + (decs==null?"":decs.toString()) + "}";
		return sol;
	}
	public String name() {
		return id.toString();
	}
	@Override
	protected void vinculo() throws Exception {
		if(banned && (name().equals("length") || name().equals("kin"))) {
			throw new Exception("Fila " + fila + ". Banned word: "+ name());
		}
		Typename.check_custom(tipo,fila);
		Program.insertaId(name(), this);
		Program.abreBloque();
		
		if(params!=null)
			params.vinculo();
		if(decs!=null) {
			decs.vinculo();
		}
		
		Program.cierraBloque();
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		Typename t = tipo.pure();
		if(t.t == Type.CUSTOM || t.t == Type.ARR)
			throw new Exception("Fila " + fila + ". Return is not basic or punterito: "+t);
		List<Typename> returns = decs.chequea();
		for(Typename ret : returns) {
			if(!ret.equals(t))
				throw new Exception("Fila " + fila + ". Bad return type: "+ t + " / " + ret);
		}
		if(returns.size() == 0)
			throw new Exception("Fila " + fila + ". Function needs returns.");
		
		return new ArrayList<>();
	}
	public Typename tipo() {
		return tipo;
	}
	int max = 0;
	boolean siesbloque = true;
	@Override
	public void maxMemory(WrapInt c, WrapInt max) {
		if (siesbloque) { // isBlock()
			siesbloque = false;
			WrapInt c1 = new WrapInt();
			WrapInt max1 = new WrapInt();
			maxMemory(c1,max1);
			if (c.v+max1.v > max.v) {
				max.v = c.v + max1.v;
			}
		} else {
			if(params!=null)
				params.maxMemory(c,max);
			if(decs!=null)
				decs.maxMemory(c,max);
		}
		this.max = max.v;
	}
	@Override
	protected String codigo() {
		String psize = (params==null?"":params.size());

		String size = 
				psize
				+ "   i32.const "+(this.max+2)*4+"\n"
						+ "i32.add\n";

		String fun = "(func $_"+id.toString()+
				" \n(result i32)"+
				"\n" + 
				Program.principio(size);
		
		fun = fun +decs.codigo()+"\n"
				;
		
		fun = fun + 
				"\n   call $freeStack\n " +
				")";
		return fun;
	}
}
