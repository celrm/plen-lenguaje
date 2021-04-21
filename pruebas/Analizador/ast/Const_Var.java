package ast;

public class Const_Var extends Var {

	public Const_Var(VarIni var) {
		super(var);
		is_const = true;
	}

}
