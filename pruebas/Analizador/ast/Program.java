package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
	private Map<String,Object> tabla = new HashMap<>();
	
	private List<Import> imps;
	private List<Declare> decs;
	private List<Instruction> mn;
	public Program(Imports imps, Declares decs, Instructions mn) {

		if(imps == null) 
			this.imps = new ArrayList<Import>();
		else
			this.imps=imps.list();

		if(decs == null) 
			this.decs = new ArrayList<Declare>();
		else
			this.decs=decs.list();

		if(mn == null) 
			this.mn= new ArrayList<Instruction>();
		else
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
