package ast;

import java.util.ArrayList;
import java.util.List;

public class Asigna extends Instr {

	private E e1;
	private E e2;

	public Asigna(E e1, E e2) {
		super(e1.fila);
		this.e1=e1;
		this.e2=e2;
		type_of_in = In.ASIGNA;
	}
	public String toString() {
		return ""+e1.toString() + "=" + e2.toString() + ".";
	}
	@Override
	protected void vinculo() throws Exception {
		e1.vinculo();
		e2.vinculo();
	}
	@Override
	protected List<Typename> chequea() throws Exception {
		if(e1.oper() != Op.ACCESO && e1.oper() != Op.INDICE && e1.oper() != Op.BASICO_ID)
			throw new Exception("No asignable: " + e1.toString());
		Typename t1 = e1.chequea();
		Typename t2 = e2.chequea();
		if(!t1.equals(t2)) throw new Exception("Fallo de tipo en asignación");
		return new ArrayList<>();
	}
}
