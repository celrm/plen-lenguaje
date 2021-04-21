package ast;

public class Var extends Declare {
	boolean is_const;
	private VarIni var;
	public Var(VarIni var) {
		this.var=var;
	}
	public VarIni var() {
		return var;
	}

}
