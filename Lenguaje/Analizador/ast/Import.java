package ast;

import alex.TV;

public class Import {
	TV name;
	TV source;
	public Import(TV name, TV source) {
		this.name=name;
		this.source=source;
	}
	public String toString() {
		return "import " + name.toString() + " from " + source.toString() + ".";
	}
	public void vinculo() {
		Program.insertaId(name.toString(), this);
	}
	public void chequea() {} // TODO ?
}
