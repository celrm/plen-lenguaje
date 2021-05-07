package ast;

import java.util.List;

public abstract class Declare extends Instr {
	Dec type_of_dec;
	public Declare() {
		type_of_in = In.DECLARE;
	}

	protected abstract void vinculo() throws Exception;

	protected abstract List<Typename> chequea() throws Exception;

	protected abstract Typename tipo();
}
