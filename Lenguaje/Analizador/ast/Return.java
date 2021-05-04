package ast;

public class Return extends Instr {
	private E exp;
	public Return(E e) {
		this.exp=e;
	}
	public String toString() {
		return "return " + exp.toString()+".";
	}
	@Override
	protected void vinculo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void chequea() throws Exception {
		// TODO Auto-generated method stub
		
	} 

}
