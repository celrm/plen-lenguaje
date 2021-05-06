package ast;

public class Fun extends Instr {
	private Call f;
	public Fun(Call f) {
		this.f=f;
		type_of_in = In.FUN;
	}
	public String toString() {
		return f.toString() + ".";
	}
	@Override
	protected void vinculo() throws Exception {
		f.vinculo();
	}
	@Override
	protected void chequea() throws Exception {
		f.chequea();
	}
}
