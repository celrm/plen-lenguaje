package ast;

public class Reg_Ins extends Instr {
	Reg reg;
	public Reg_Ins(Reg i) {
		reg=i;
	}
	public String toString() {
		return reg.toString();
	}
}
