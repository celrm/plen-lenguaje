package ast;

import alex.TV;

public class ASExp {
	public E op_acceso(Object opnd1, Object opnd2,Object oper) 
	{ return new EAcceso((E)opnd1,(EBasico)opnd2,(Op)oper); }
	public E op_bin(Object opnd1, Object opnd2,Object oper) 
	{ return new EBin((E)opnd1,(E)opnd2,(Op)oper); }
	public E op_mono(Object opnd1,Object oper) 
		{ return new EMono((E)opnd1,(Op)oper); }
	public E op_call(Object id, Object v) 
		{ return new Call((TV)id,(HeterValues)v); }
	public E op_listinit(Object l) 
		{ return new ListInit((HomogValues)l); }
	public HomogValues list_cons(Object e,Object rest) 
		{ return new HomogValues((E)e,(HomogValues)rest); }
	public E op_basico_ent(Object e) 
	{ return new EBasico((TV)e,Op.BASICO_ENT); }
	public E op_basico_bul(Object e) 
	{ return new EBasico((TV)e,Op.BASICO_BUL); }
	public E op_basico_car(Object e) 
	{ return new EBasico((TV)e,Op.BASICO_CAR); }
	public E op_basico_id(Object e) 
	{ return new EBasico((TV)e,Op.BASICO_ID); }
}
