package ast;

import java.util.List;

public abstract class Instr {

	In type_of_in;
	protected abstract void vinculo() throws Exception;
	protected abstract List<Typename> chequea() throws Exception;


}
