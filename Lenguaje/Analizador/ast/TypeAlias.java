package ast;

import java.util.Map;

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
	@Override
	protected void vinculo() {
				
	}
	public void chequea_prep(Map<String, Typename> typedefs) {
		typedefs.put(id.toString(),tipo);
	}
	@Override
	protected void chequea() {
		// TODO Auto-generated method stub
		
	}
}
