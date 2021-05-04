package ast;

public class Kut extends Instr {
	private E print;
	public Kut(E i) {
		print=i;
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
		// TODO Auto-generated method stub
		
	}
}
