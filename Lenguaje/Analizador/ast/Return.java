package ast;

import java.util.ArrayList;
import java.util.List;

public class Return extends Instr {
	private E exp;
	public Return(E e) {
		super(e.fila);
		this.exp=e;
		type_of_in = In.RETURN;
	}
	public String toString() {
		return "return " + exp.toString()+".";
	}
	@Override
	protected void vinculo() throws Exception {
		exp.vinculo();		
	}
	Typename tipo;
	@Override
	protected List<Typename> chequea() throws Exception {
		tipo = exp.chequea().pure();
		List<Typename> rets = new ArrayList<>();
		rets.add(tipo);
		return rets;
	}
	public Typename tipo() {
		return tipo;
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max, WrapInt delta) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected String codigo() {
		String codeE = exp.codigo();
		String sol = codeE;
		return sol;
	} 

}
