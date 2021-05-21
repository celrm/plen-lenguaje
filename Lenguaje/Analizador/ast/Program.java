package ast;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
	public int size() {
		return 0;
	}

	boolean siesbloque = true;
	public void maxMemory(WrapInt c, WrapInt max, WrapInt delta) {
		if (siesbloque) { // isBlock()
			siesbloque = false;
			WrapInt c1 = new WrapInt();
			WrapInt max1 = new WrapInt();
			WrapInt delta1 = new WrapInt();
			maxMemory(c1,max1,delta1);
			if (c.v+max1.v > max.v) {
				max.v = c.v + max1.v;
			}
		} else {
//			if(decs!=null) 
//			decs.maxMemory(c,max,delta);
		if(mn!=null)
			mn.maxMemory(c,max,delta);
			
		}
	}
	
	public void codigo(String fichero) {
		maxMemory(new WrapInt(),new WrapInt(),new WrapInt());
		
		
		String main = "(func $main  (type $_sig_void)\n" + principio();
		

//		if(imps!=null)
//			imps.codigo();
//		
//		if(decs!=null)
//			decs.codigo();
		
		if(mn!=null) 
			main = main + mn.codigo();
		
//		acceso
//		get $start si es mía la variable
//		+
//		(i + despl(si array))*4
		
		main = main + 
				"\n   call $freeStack\n " +
				")";
		
		String webas = cabecera() + main + stack() + ")";
		PrintWriter writer;
		try {
			writer = new PrintWriter(fichero+".wat", "UTF-8");
			writer.println(webas);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String cabecera() {
		return "(module\n" + 
				"(type $_sig_i32ri32 (func (param i32) (result i32)))\n" + 
				"(type $_sig_i32 (func (param i32)))\n" + 
				"(type $_sig_ri32 (func (result i32)))\n" + 
				"(type $_sig_void (func ))\n" + 
				"(import \"runtime\" \"exceptionHandler\" (func $exception (type $_sig_i32)))\n" + 
				"(import \"runtime\" \"print\" (func $print (type $_sig_i32)))\n" + 
				"(import \"runtime\" \"read\" (func $read (type $_sig_ri32)))\n" + 
				"(memory 2000)\n" + 
				"(global $SP (mut i32) (i32.const 0)) ;; start of stack\n" + 
				"(global $MP (mut i32) (i32.const 0)) ;; mark pointer\n" + 
				"(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4\n" + 
				"(start $main)\n";
	}
	
	private static final String stack() {
		return "(func $reserveStack (param $size i32)\n" + 
				"   (result i32)\n" + 
				"   get_global $MP\n" + 
				"   get_global $SP\n" + 
				"   set_global $MP\n" + 
				"   get_global $SP\n" + 
				"   get_local $size\n" + 
				"   i32.add\n" + 
				"   set_global $SP\n" + 
				"   get_global $SP\n" + 
				"   get_global $NP\n" + 
				"   i32.gt_u\n" + 
				"   if\n" + 
				"   i32.const 3\n" + 
				"   call $exception\n" + 
				"   end\n" + 
				")\n" + 
				"(func $freeStack (type $_sig_void)\n" + 
				"   get_global $MP\n" + 
				"   i32.load\n" + 
				"   i32.load offset=4\n" + 
				"   set_global $SP\n" + 
				"   get_global $MP\n" + 
				"   i32.load\n" + 
				"   set_global $MP   \n" + 
				")";
	}
	
	public static final String principio() {
		return "(local $localsStart i32)\n" + 
				"   (local $temp i32)\n" + 
				"   i32.const 200  ;; let this be the stack size needed (params+locals+2)*4\n" + 
				"   call $reserveStack  ;; returns old MP (dynamic link)\n" + 
				"   set_local $temp\n" + 
				"   get_global $MP\n" + 
				"   get_local $temp\n" + 
				"   i32.store\n" + 
				"   get_global $MP\n" + 
				"   get_global $SP\n" + 
				"   i32.store offset=4\n" + 
				"   get_global $MP\n" + 
				"   i32.const 8\n" + 
				"   i32.add\n" + 
				"   set_local $localsStart\n";
	}
}
