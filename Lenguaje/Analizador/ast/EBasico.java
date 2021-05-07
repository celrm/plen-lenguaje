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
	public void vinculo() throws Exception {
		if(oper()==Op.BASICO_ID)
			d = (Declare) Program.buscaId(id.toString()); 
		// por definición de declare, son todos los sitios donde he hecho inserts
	}
	@Override
	public Typename chequea() {
		switch(oper()) {
		case BASICO_BUL:
			return new Typename("bul");
		case BASICO_CAR:
			return new Typename("car");
		case BASICO_ENT:
			return new Typename("ent");
		case BASICO_ID:
			return d.tipo().pure(); 
		default:
			break;
		}
		return null;
	}

}
