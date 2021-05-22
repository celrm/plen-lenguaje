package ast;

import alex.TV;

public class EBasico extends E {
	TV id;
	public EBasico(TV id, Op basicoEnt) {
		super(basicoEnt,id.fila);
		this.id = id;
	}
	public String toString() {
		return id.toString();
	}
	Declare d;
	@Override
	public void vinculo() throws Exception {
		if(oper()==Op.BASICO_ID)
			d = (Declare) Program.buscaId(id.toString(),fila);
		// por definición de declare, son todos los sitios donde he hecho inserts
	}
	@Override
	public Typename chequea() {
		switch(oper()) {
		case BASICO_BUL:
			tipo  = new Typename("bul");
			break;
		case BASICO_CAR:
			tipo = new Typename("car");
			break;
		case BASICO_ENT:
			tipo = new Typename("ent");
			break;
		case BASICO_ID:
			tipo = d.tipo().pure(); 
			break;
		default:
			break;
		}
		return tipo;
	}
	@Override
	protected String codigo() {
		String sol = "";

		switch(oper()) {
		case BASICO_BUL:
			sol = sol + "   i32.const " + (id.toString().equals("si") ? "0" : "1");
			break;
		case BASICO_CAR:
			break;
		case BASICO_ENT:
			sol = sol + "   i32.const " + id.toString();
			break;
		case BASICO_ID:
			int delta = d.delta;
			sol = sol +
					"	get_local $localsStart\n" +
					"   i32.const " + delta*4 + "\n"+
					"	i32.add\n" +
					"	i32.load\n"
					;
			break;
		default:
			break;
		}
		
		return sol + "\n";
	}
	
}
