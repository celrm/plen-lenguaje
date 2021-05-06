package ast;

public class Return extends Instr {
	private E exp;
	public Return(E e) {
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
	String tipo;
	@Override
	protected void chequea() throws Exception {
		tipo = exp.chequea();
	}
	public String tipo() {
		return tipo;
	} 

}
