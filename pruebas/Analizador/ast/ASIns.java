package ast;

import alex.TV;

public class ASIns {
	public Program program(Object imps, Object decs, Object mn) 
		{ return new Program((Imports)imps,(Declares)decs,(Instructions)mn); }
	public Imports imports(Object name, Object source, Object rest) 
		{ return new Imports((TV)name,(TV)source,(Imports)rest); }
	
	public Declares declares(Object var, Object rest,Object dectype) 
		{ return new Declares((Declare)var,(Declares)rest,(Dec) dectype); }

	public Declare dec_var(Object t,Object i,Object e,boolean is_const) 
		{ return new Var((Typename) t,(TV) i,(E) e, is_const); }
	public Declare dec_reg(Object tipo, Object id, Object values ) 
		{ return new Reg((Typename)tipo,(TV)id,(HeterValues)values); }
	public Declare dec_defreg(Object id, Object params, Object d ) 
		{ return new DefReg((TV)id,(Params)params,(Instructions)d); }
	public Declare dec_type(Object id, Object tipo) 
		{ return new TypeAlias((TV)id,(Typename)tipo); }
	public Declare dec_fun(Object id, Object tipo, Object params, Object d ) 
		{ return new DefFun((TV)id,(Typename)tipo,(Params)params,(Instructions)d); }

	public Params params(Object tipo, Object id, Object rest,boolean is_const) 
		{ return new Params((Typename)tipo,(TV)id,(Params)rest,is_const); }
	
	public Instructions instructions(Object i, Object rest) 
		{ return new Instructions((Instr)i,(Instructions)rest); }

	public Instr ins_asign(Object e1,Object e2) 
		{ return new Asigna((E)e1,(E)e2); }
	public Instr ins_return(Object e) 
		{ return new Return((E)e); }
	public Instr ins_kut(Object i) 
		{ return new Kut((E)i); }
	public Instr ins_while(Object b, Object d) 
		{ return new While((E)b,(Instructions)d); }
	public Instr ins_for(Object elem, Object arr, Object d) 
		{ return new For((TV)elem,(E)arr,(Instructions)d); }
	public Instr ins_if(Object b,Object d) 
		{ return new If((E)b,(Instructions)d); }
	public Instr ins_elseif(Object b,Object d) 
		{ return new ElseIf((E)b,(Instructions)d); }
	public Instr ins_else(Object d) 
		{ return new Else((Instructions)d); }
	public Instr ins_fun(Object f) 
		{ return new Fun((Call)f); }

	public HeterValues values(Object e,Object rest) 
		{ return new HeterValues((E)e,(HeterValues)rest); }

	public Typename typename(Object e) 
		{ return new Typename((TV)e); }
	public Typename typename_arr(Object e) 
		{ return new Typename((Typename)e); }
	
	  
}
