package ast;

import alex.TV;

public class Import extends Declare {
	TV name;
	TV source;
	Program p;
	public Import(TV name, TV source) {
		this.name=name;
		this.source=source;
		type_of_dec = Dec.IMPORT;
		type_of_in = In.DECLARE;
	}
	public String toString() {
		return "import " + name.toString() + " from " + source.toString() + ".";
	}
	public void vinculo() {
		Program.insertaId(name.toString(), this);
	}
	public void chequea() {} // TODO ?
	@Override
	protected Typename tipo() {
		// TODO Auto-generated method stub
		return null;
	}
}
