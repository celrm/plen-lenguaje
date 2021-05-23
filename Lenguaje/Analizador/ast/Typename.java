package ast;

import alex.TV;

public class Typename {	
	Typename t_arr;
	private TV t_id;
	Type t;

	public Typename(TV id) {
		this.t_id=id;
		if(id.toString().equals("ent")) 
			t = Type.ENT;
		else if(id.toString().equals("bul")) 
			t = Type.BUL;
		else if(id.toString().equals("car")) 
			t = Type.CAR;
		else t = Type.CUSTOM;
	}
	public Typename(Typename e,Type t) {
		t_arr = e;	
		this.t = t;
	}
	public Typename(String s) {
		this(new TV(s, -1));
	}

	public String toString() {
		if (t == Type.ARR) {
			return "arr\\" + t_arr.toString();
		}
		if (t == Type.PUNT) {
			return "*" + t_arr.toString();
		}
		if(t_id != null) {
			return t_id.toString();
		}
		return null;
	}
	public Typename pure() {
		if(t_id != null) {
			Typename from = this;
			Typename to = Program.get_alias(from.toString());
			while(to != null) {
				from = to.pure();
				to = Program.get_alias(from.toString());
			}
			return from;
		}
		else if (t == Type.ARR || t == Type.PUNT) {
			Typename nuevo = new Typename(t_arr.pure(),t);
			nuevo.tam = tam;
			return nuevo;
		}
		return null;
	}
	public boolean equals(Typename y) {
		Typename t1 = pure();
		Typename t2 = y.pure();
		if(t1.t == Type.CUSTOM && t1.t_id.toString().equals("*"))
			return true;
		if(t2.t == Type.CUSTOM && t2.t_id.toString().equals("*"))
			return true;
		if(t2.t != t1.t)
			return false;
		if(t1.t == Type.ARR) {
			return t2.t == Type.ARR &&
					t2.t_arr.equals(t1.t_arr);
		}
		if(t1.t == Type.PUNT) {
			return t2.t == Type.PUNT &&
					t2.t_arr.equals(t1.t_arr);
		}
		if(t1.t_id == null || 
				!t1.t_id.toString().equals(t2.t_id.toString())) 
			return false;
		return true;
	}

	public static void check_custom(Typename tipo2,int fila) throws Exception {
		switch(tipo2.t) {
		case PUNT:
		case ARR:
			check_custom(tipo2.t_arr,fila);
			break;
		case BUL:
		case CAR:
		case ENT:
			break;
		case CUSTOM:
			if(!tipo2.toString().equals("*")) {
				@SuppressWarnings("unused") 
				Declare tp = (Declare) Program.buscaId(tipo2.toString(),fila);
			}
			break;
		default:
			break;
		
		}
	}
	int tam = 1;
	public int size() {
		switch(t) {
		case ARR:
			return tam;
		case CUSTOM:
			break;
		case BUL:
		case CAR:
		case ENT:
		case PUNT:
			return 1;
		default:
			break;
		}
		return 1;
	}
}
