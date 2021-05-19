package ast;

import java.util.ArrayList;
import java.util.List;

public class Kut extends Instr {
	private E print;
	public Kut(E i) {
		super(i.fila);
		print=i;
		type_of_in = In.KUT;
	}
	public String toString() {
		return "kut("+print.toString()+").";
	}
	@Override
	protected void vinculo() throws Exception {
		print.vinculo();		
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		Typename s = print.chequea().pure();
		if(s.t != Type.ENT && s.t != Type.BUL && s.t != Type.CAR) {

			throw new Exception("Fila " + fila + ". No kuteable");
		
		}
		return new ArrayList<>();
	}
}
