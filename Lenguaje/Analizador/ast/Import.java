package ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alex.TV;
import asint.Main;

public class Import extends Declare {
	TV name;
	TV source;
	Program p;
	Declare d; // si hay * es null
	public Import(TV name, TV source, int fila) {
		super(fila);
		this.isconst = true;
		this.name=name;
		this.source=source;
		type_of_dec = Dec.IMPORT;
	}
	public String toString() {
		return "import " + name.toString() + " from " + source.toString() + ".";
	}
	public void vinculo() throws Exception {
		p = Main.abrirFichero(source.toString()); // compilado ahí
		p.vinculo(false);
		p.chequea();
		 
		Declares decs = p.decs;
		Program.abreBloque();
		if(decs!=null) decs.vinculo();
		Map<String, Object> tabla = Program.tablaSimbolos();
		Program.cierraBloque();
		
		if(name.toString().equals("*")) {
			for(Object d : tabla.values()) {
				Program.insertaId(name.toString(), (Declare) d);
			}
		}
		else  {
			d = (Declare) tabla.get(name.toString());
			Program.insertaId(name.toString(), d);
		}
	}
	public List<Typename> chequea() {
		return new ArrayList<>();}
	@Override
	protected Typename tipo() {
		return d.tipo();
	}
	@Override
	protected String name() {
		return name.toString();
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max) {
		if(d==null) {
			System.out.println("Fila"+fila+": import * no implementado");
			return;
		}
		d.maxMemory(c, max);
	}
	@Override
	protected String codigo() {
		if(d.type_of_dec==Dec.FUNCTION) {
			return d.codigo();
		}
		return "";
	}
}
