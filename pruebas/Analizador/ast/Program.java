package ast;

import java.util.List;

public class Program {
	private List<Import> imps;
	private List<Declare> decs;
	private List<Instruction> mn;
	public Program(Imports imps, Declares decs, Instructions mn) {
		this.imps=imps.list();
		this.decs=decs.list();
		this.mn=mn.list();
	}
	public List<Import> imps() {
		return imps;
	}
	public List<Declare> decs() {
		return decs;
	}
	public List<Instruction> mn() {
		return mn;
	}
}
