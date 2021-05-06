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
	}
	public String toString() {
		return "type " + id.toString() + " = " + tipo.toString() + "."; 
	}
	@Override
	protected void vinculo() {
		Program.insertaId(id.toString(), this);
	}
	public void chequea_prep(Map<String, Typename> typedefs) {
		typedefs.put(id.toString(),tipo);
	}
	@Override
	protected void chequea() {
		// TODO Auto-generated method stub
		
	}
}
