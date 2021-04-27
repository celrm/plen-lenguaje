package ast;

import alex.TV;

public class TypeAlias extends Declare {
	private TV id;
	private Typename tipo;

	public TypeAlias(TV id, Typename tipo) {
		type_of_dec=Dec.TYPE;
		this.id=id;
		this.tipo=tipo;
	}
	public String toString() {
		return "type " + id.toString() + " = " + tipo.toString() + "."; 
	}
}
