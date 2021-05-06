package ast;

public class Asigna extends Instr {

	private E e1;
	private E e2;

	public Asigna(E e1, E e2) {
		this.e1=e1;
		this.e2=e2;
	}
	public String toString() {
		return ""+e1.toString() + "=" + e2.toString() + ".";
	}
	@Override
	protected void vinculo() throws Exception {
		if(e1.oper() != Op.ACCESO && e1.oper() != Op.INDICE)
			throw new Exception("No asignable: " + e1.toString());
		e1.vinculo();
		e2.vinculo();
	}
	@Override
	protected void chequea() throws Exception {
		String t1 = e1.chequea();
		String t2 = e2.chequea();
		if(!t1.equals(t2)) throw new Exception("Fallo de tipo");
	}
}
