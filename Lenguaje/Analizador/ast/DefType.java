package ast;

import java.util.Map;

import alex.TV;

public class DefType extends Declare {
	private TV id;
	private Typename tipo;

	public DefType(TV id, Typename tipo) {
		type_of_dec=Dec.TYPE;
		this.id=id;
		this.tipo=tipo;
		type_of_in = In.DECLARE;
	}
	public String toString() {
		return "type " + id.toString() + " = " + tipo.toString() + "."; 
	}
	public String name() {
		return id.toString();
	}
	@Override
	protected void vinculo() {
		Program.insertaId(name(), this);
	}
	public void chequea_prep(Map<String, Typename> typedefs) {
		typedefs.put(name(),tipo);
	}
	@Override
	protected void chequea() {}
	@Override
	protected Typename tipo() {
		return tipo;
	}
}
