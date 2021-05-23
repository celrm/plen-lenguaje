package ast;

import java.util.ArrayList;
import java.util.List;

public class Fun extends Instr {
	private Call f;
	public Fun(Call f) {
		super(f.fila);
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
	protected List<Typename> chequea() throws Exception {
		f.chequea();
		return new ArrayList<>();
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max) {
//		f.f.maxMemory(c,max); TODO
	}
	@Override
	protected String codigo() {
		return f.codigo();
	}
}
