package ast;

public class Kut extends Instr {
	private E print;
	public Kut(E i) {
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
	protected void chequea() throws Exception {
		Typename s = print.chequea();
		if(s.t != Type.ENT && s.t != Type.BUL) {

			throw new Exception("no kuteable");
		
		}
	}
}
