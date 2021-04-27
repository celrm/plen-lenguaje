package ast;

public class Var_Ins extends Instr {
	Var var;
	public Var_Ins(Var i) {
		var=i;
	}
	public String toString() {
		return var.toString();
	}
}
