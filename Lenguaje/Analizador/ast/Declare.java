package ast;

public abstract class Declare extends Instr {
	Dec type_of_dec;

	protected abstract void vinculo() throws Exception;

	protected abstract void chequea() throws Exception;

	protected abstract Typename tipo();
}
