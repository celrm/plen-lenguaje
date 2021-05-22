package ast;

import java.util.List;

public abstract class Instr {

	In type_of_in;
	int fila;
	public Instr(int fila2) {
		fila = fila2;
	}
	protected abstract void vinculo() throws Exception;
	protected abstract List<Typename> chequea() throws Exception;
	protected abstract String codigo();
	protected abstract void maxMemory(WrapInt c, WrapInt max);


}
