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
	@Override
	protected void maxMemory(WrapInt c, WrapInt max, WrapInt delta) { 
//		if (false) { // isDef()
////			c += size();
////			if (c > max) max = c; 
////			this.delta = delta;
////			delta++;
//		} else if (false) { // isBlock()
//			Integer c1 = 0;
//			Integer max1 = 0;
//			Integer delta1 = 0;
//			maxMemory(c1,max1,delta1);
//			if (c+max1 > max) {
//				max = c + max1;
//			}
//		} else {
//		}
	}
//	private Integer size() {
//		int size = 0;
//		size = size + params.size();
//		size = size + params.size();
//		return 0;
//	}
}
