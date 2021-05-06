package ast;

import alex.TV;

public class EBasico extends E {
	TV id;
	public EBasico(TV id, Op basicoEnt) {
		super(basicoEnt);
		this.id = id;
	}
	public String toString() {
		return id.toString();
	}
	Declare d;
	@Override
	protected void vinculo() throws Exception {
		if(oper()==Op.BASICO_ID)
			d = (Declare) Program.buscaId(id.toString()); 
		// por definición de declare, son todos los sitios donde he hecho inserts
	}
	@Override
	protected String chequea() {
		switch(oper()) {
		case BASICO_BUL:
			return "bul";
		case BASICO_CAR:
			return "car";
		case BASICO_ENT:
			return "ent";
		case BASICO_ID:
			return chequea(); // TODO
		default:
			break;
		}
		return null;
	}

}
