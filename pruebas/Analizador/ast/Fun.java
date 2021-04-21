package ast;

import exp.Call;

public class Fun extends Instruction {
	Call f;
	public Fun(Call f) {
		this.f=f;
	}

}
