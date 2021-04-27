package ast;

public class Program {	
	private Imports imps;
	private Declares decs;
	private Instructions mn;
	public Program(Imports imps, Declares decs, Instructions mn) {
		this.imps=imps;
		this.decs=decs;
		this.mn=mn;
	}
	public String toString() {
		String sol = (imps==null?"":imps.toString())+ "\n";
		sol = sol + (decs==null?"":decs.toString()) + "\n";
		return sol + "main {\n" + (mn==null?"":mn.toString())+ "}";
	}
}
