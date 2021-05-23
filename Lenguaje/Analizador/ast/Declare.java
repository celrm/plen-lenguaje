package ast;

import java.util.List;

public abstract class Declare extends Instr {
	Dec type_of_dec;
	int delta;
	boolean isconst;
	public Declare(int fila) {
		super(fila);
		type_of_in = In.DECLARE;
	}

	protected abstract void vinculo() throws Exception;

	protected abstract List<Typename> chequea() throws Exception;

	protected abstract String name();

	protected abstract Typename tipo();

	protected abstract void maxMemory(WrapInt c, WrapInt max);

}
