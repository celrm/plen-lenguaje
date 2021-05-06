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
		String s = print.chequea();
		if(!s.equals("ent") && !s.equals("bul")) {

			throw new Exception("no kuteable");
		
		}
	}
}
