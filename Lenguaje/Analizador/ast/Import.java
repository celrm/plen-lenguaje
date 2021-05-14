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
	public Import(TV name, TV source, int fila) {
		super(fila);
		this.name=name;
		this.source=source;
		type_of_dec = Dec.IMPORT;
	}
	public String toString() {
		return "import " + name.toString() + " from " + source.toString() + ".";
	}
	public void vinculo() throws Exception {
		p = Main.abrirFichero(source.toString()); // compilado ahí
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
			Declare d = (Declare) tabla.get(name.toString());
			Program.insertaId(name.toString(), d);
		}
	}
	public List<Typename> chequea() {
		return new ArrayList<>();} // TODO ?
	@Override
	protected Typename tipo() {
		// TODO Auto-generated method stub
		return null;
	}
}
