package ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import alex.TV;

public class Program {	
	private Imports imps;
	Declares decs;
	private Instructions mn;
	public Program(Imports imps, Declares decs, Instructions mn) {
		this.imps=imps;
		this.decs=decs;
		this.mn=mn;
	}
	public String toString() {
		String sol = (imps==null?"":imps.toString())+ "\n";
		sol = sol + (decs==null?"":decs.toString()) + "\n";
		return sol + "main {\n" + (mn==null?"":mn.toString())+ "}";
	}
	////////////////
	private static Stack<Map<String,Object>> pila;
	public static void inicializa() {
		
		pila = new Stack<>();
	}
	public static void abreBloque() {
		pila.add(new HashMap<>());
	}
	public static void cierraBloque() {
		pila.pop();
	}
	public static Map<String, Object> tablaSimbolos() {
		return pila.firstElement();
	}
	public static void insertaId(String ident,Object puntero) {
		pila.firstElement().put(ident,puntero);
	}
	public static Object buscaId(String ident, int fila) throws Exception {
		for(Map<String,Object> m : pila) { // mirar si va de arriba abajo
			Object sol = m.get(ident);
			if(sol != null) return sol;
		}
		throw new Exception("Fila " + fila + ". Error de vinculación: " + ident);
	}
	
	private DefFun kin = new DefFun(
			new TV("kin",-1), new Typename(new TV("*",-1)), null, null);
	private Length length = new Length();
	
	public void vinculo() {

		typedefs = new HashMap<>(); // lo necesito aquí y no en chequea para usarlo en registros

		if(decs!=null)
		decs.chequea_prep(typedefs);
		inicializa();
		abreBloque();

		try {
			kin.vinculo();
			length.vinculo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefFun.banned = true; // ban these words
		
		if(imps!=null)
			imps.vinculo();
		if(decs!=null)
			decs.vinculo();
		if(mn!=null)
			mn.vinculo();
		
		cierraBloque();
	}
	private static Map<String,Typename> typedefs;
	public static Typename get_alias(String from) {
		Typename t = typedefs.get(from);
		return t;
	}
	public void chequea() {

		if(imps!=null)
		imps.chequea();
		
		if(decs!=null)
		decs.chequea();
		
		if(mn!=null) {
			List<Typename> returns = mn.chequea();
			Typename t = new Typename("ent");
			for(Typename ret : returns) {
				if(!ret.equals(t))
					System.out.println("Main. Bad return type: "+ t + " / " + ret);
			}
		}
	}
}
