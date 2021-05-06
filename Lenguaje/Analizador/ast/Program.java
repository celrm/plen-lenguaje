package ast;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Program {	
	private Imports imps;
	private Declares decs;
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
	public static Map<String, Object> paraRegistros() {
		return pila.firstElement();
	}
	public static void insertaId(String ident,Object puntero) {
		pila.firstElement().put(ident,puntero);
	}
	public static Object buscaId(String ident) throws Exception {
		for(Map<String,Object> m : pila) { // mirar si va de arriba abajo
			Object sol = m.get(ident);
			if(sol != null) return sol;
		}
		throw new Exception("Error de vinculación: " + ident);
	}
	
	public void vinculo() throws Exception {
		inicializa();
		abreBloque();
		
		if(imps!=null)
			imps.vinculo();
		if(decs!=null)
			decs.vinculo();
		if(mn!=null)
			mn.vinculo();
		
		cierraBloque();
	}
	private static Map<String,Typename> typedefs;
	public static Typename get_alias(String arg0) {
		return typedefs.get(arg0);
	}
	public void chequea() throws Exception {
		typedefs = new HashMap<>();
		decs.chequea_prep(typedefs);
		
		imps.chequea();
		decs.chequea();
		mn.chequea();
	}
}
