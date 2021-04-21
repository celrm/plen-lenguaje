package ast;

import alex.TV;

public class ASIns {
	public Program program(Object imps, Object decs, Object mn) 
		{ return new Program((Imports)imps,(Declares)decs,(Instructions)mn); }
	public Imports imports(Object name, Object source, Object rest) 
		{ return new Imports((TV)name,(TV)source,(Imports)rest); }
	
	public Declares decvar(Object var, Object rest) 
		{ return new Decvar((Var)var,(Declares)rest); }
	public Declares decvarreg(Object var, Object rest) 
		{ return new Decvarreg((Reg)var,(Declares)rest); }
	public Declares decreg(Object var, Object rest) 
		{ return new Decreg((RegIni)var,(Declares)rest); }
	public Declares decfun(Object var, Object rest) 
		{ return new Decfun((FunIni)var,(Declares)rest); }
	public Declares dectype(Object var, Object rest) 
		{ return new Dectype((TypeIni)var,(Declares)rest); }

	public Var const_var(Object var) 
		{ return new Const_Var((VarIni)var); }
	public Var noconst_var(Object var) 
		{ return new NoConst_Var((VarIni)var); }

	public VarIni var_init(Object tipo, Object id, Object exp ) 
		{ return new VarIni((Typename)tipo,(TV)id,(E)exp); }
	public Reg varreg_init(Object tipo, Object id, Object values ) 
		{ return new Reg((Typename)tipo,(TV)id,(HeterValues)values); }

	public RegIni reg_init(Object id, Object params, Object d ) 
		{ return new RegIni((TV)id,(Params)params,(Declares)d); }
	public Params cparams(Object tipo, Object id, Object rest ) 
		{ return new Const_Param((Typename)tipo,(TV)id,(Params)rest); }
	public Params params(Object tipo, Object id, Object rest ) 
		{ return new NoConst_Param((Typename)tipo,(TV)id,(Params)rest); }

	public TypeIni type_init(Object id, Object tipo) 
		{ return new TypeIni((TV)id,(Typename)tipo); }
	public FunIni fun_init(Object id, Object tipo, Object params, Object d ) 
		{ return new FunIni((TV)id,(Typename)tipo,(Params)params,(Instructions)d); }
	
	public Instructions instructions(Object i, Object rest) 
		{ return new Instructions((Instruction)i,(Instructions)rest); }

	public Instruction ins_var(Object i) 
		{ return new Decvar_Ins((Decvar)i); }
	public Instruction ins_varreg(Object i) 
		{ return new Decvarreg_Ins((Decvarreg)i); }
	public Instruction ins_return(Object e) 
		{ return new Return((E)e); }
	public Instruction ins_kut(Object i) 
		{ return new Kut((E)i); }
	public Instruction ins_while(Object b, Object d) 
		{ return new While((E)b,(Instructions)d); }
	public Instruction ins_for(Object elem, Object arr, Object d) 
		{ return new For((TV)elem,(E)arr,(Instructions)d); }
	public Instruction ins_if(Object b,Object d) 
		{ return new If((E)b,(Instructions)d); }
	public Instruction ins_ifelse(Object b,Object d) 
		{ return new IfElse((E)b,(Instructions)d); }
	public Instruction ins_else(Object d) 
		{ return new Else((Instructions)d); }
	public Instruction ins_fun(Object f) 
		{ return new Fun((Call)f); }
	
	public HeterValues values(Object e,Object rest) 
		{ return new HeterValues((E)e,(HeterValues)rest); }
	public Typename t_ent(Object e)
		{ return new Ent((TV)e); }
	public Typename t_bul(Object e)
		{ return new Bul((TV)e); }
	public Typename t_car(Object e)
		{ return new Car((TV)e); }
	public Typename t_id(Object e)
		{ return new IdType((TV)e); }
	public Typename t_array(Object e)
		{ return new ArrayType((Typename)e); }

	public E call(Object id, Object v) 
		{ return new Call((TV)id,(HeterValues)v); }
	public E list_init(Object l) 
		{ return new ListInit((HomogValues)l); }
	public HomogValues list_cons(Object e,Object rest) 
		{ return new HomogValues((E)e,(HomogValues)rest); }
	  
}
