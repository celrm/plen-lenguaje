package ast;

public class NoConst_Var extends Var {

	public NoConst_Var(VarIni var) {
		super(var);
		is_const=false;
	}

}
