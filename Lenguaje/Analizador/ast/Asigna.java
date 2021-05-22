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
		Typename t1 = e1.chequea().pure();
		Typename t2 = e2.chequea().pure();
		if(!t1.equals(t2)) throw new Exception("Fila " + fila + ". Fallo de tipo en asignación");
		if(!designable(e1))
			throw new Exception("Fila " + fila + ". No designable: " + e1.toString());
		return new ArrayList<>();
	}
	
	public static boolean designable(E e1) {
		return e1.oper() == Op.ACCESO 
			|| e1.oper() == Op.INDICE 
			|| e1.oper() == Op.PUNTERO 
			|| (e1.oper() == Op.BASICO_ID
			&& !((EBasico) e1).d.isconst);
	}
	@Override
	protected void maxMemory(WrapInt c, WrapInt max) {}
	protected String codigo() {
		String codeE1 = "";
		if(e1.oper() == Op.ACCESO) {//TODO
		}
		if(e1.oper() == Op.INDICE) {
			codeE1 = ((EIndice) e1).getref();
		}
		if(e1.oper() == Op.PUNTERO) {
			codeE1 = e1.codigo();
		}
		if(e1.oper() == Op.BASICO_ID) {
			codeE1 = ((EBasico) e1).getref();
		}
		String codeE2 = e2.codigo();
		String sol = 
				codeE1 +
				codeE2+
				"i32.store\n"
				;		
		return sol;
	}
}
