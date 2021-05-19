package ast;

import alex.TV;

public class ASExp {
	public E op_new(Object t,TV fila) 
	{ return new ENew((Typename)t,Op.BASICO_NEW,fila.fila); }
	public E op_punt(Object opnd,Object oper,TV fila) 
	{ return new EPunt((E)opnd,(Op)oper, fila.fila); }
	public E op_puntinv(Object opnd,Object oper,TV fila) 
	{ return new EPuntInv((E)opnd,(Op)oper, fila.fila); }
	public E op_acceso(Object opnd1, Object opnd2,Object oper,TV fila) 
	{ return new EAcceso((E)opnd1,(EBasico)opnd2,(Op)oper, fila.fila); }
	public E op_indice(Object opnd1, Object opnd2,Object oper,TV fila)  
		{ return new EIndice((E)opnd1,(E)opnd2,(Op)oper, fila.fila); }
	public E op_bin(Object opnd1, Object opnd2,Object oper,TV fila) 
	{ return new EBin((E)opnd1,(E)opnd2,(Op)oper, fila.fila); }
	public E op_mono(Object opnd1,Object oper,TV fila) 
		{ return new EMono((E)opnd1,(Op)oper, fila.fila); }
	public E op_call(Object id, Object v,TV fila) 
		{ return new Call((TV)id,(HeterValues)v, fila.fila); }
	public E op_listinit(Object l,TV fila) 
		{ return new ListInit((HomogValues)l, fila.fila); }
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
