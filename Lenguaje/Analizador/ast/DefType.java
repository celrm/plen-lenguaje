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
	public void chequea_prep(Map<Typename, Typename> typedefs) {
		typedefs.put(new Typename(id),tipo);
	}
	@Override
	protected void chequea() throws Exception {
		if(name().equals("ent") || name().equals("car") || name().equals("bul"))
		throw new Exception("No definas otra vez "+name());
	}
	@Override
	protected Typename tipo() {
		return tipo;
	}
}
