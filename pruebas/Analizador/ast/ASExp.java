package ast;

import exp.Acceso;
import exp.And;
import exp.ArrayInit;
import exp.Distinto;
import exp.Div;
import exp.E;
import exp.Igual;
import exp.Indice;
import exp.Maq;
import exp.Mayor;
import exp.Menor;
import exp.Meq;
import exp.Mod;
import exp.Mul;
import exp.Not;
import exp.Or;
import exp.Resta;
import exp.Signo;
import exp.Suma;

public class ASExp {
	public E acceso(Object opnd1, Object opnd2) {return new Acceso((E)opnd1,(E)opnd2);} 
	public E indice(Object opnd1, Object opnd2) {return new Indice((E)opnd1,(E)opnd2);} 
	public E signo(Object opnd) {return new Signo((E)opnd);}
	public E mod(Object opnd1, Object opnd2) {return new Mod((E)opnd1,(E)opnd2);}  
	public E div(Object opnd1, Object opnd2) {return new Div((E)opnd1,(E)opnd2);}  
	public E mul(Object opnd1, Object opnd2) {return new Mul((E)opnd1,(E)opnd2);}  
	public E suma(Object opnd1, Object opnd2) {return new Suma((E)opnd1,(E)opnd2);}
	public E resta(Object opnd1, Object opnd2) {return new Resta((E)opnd1,(E)opnd2);}
	public E not(Object opnd) {return new Not((E)opnd);}
	public E meq(Object opnd1, Object opnd2) {return new Meq((E)opnd1,(E)opnd2);}
	public E maq(Object opnd1, Object opnd2) {return new Maq((E)opnd1,(E)opnd2);}
	public E menor(Object opnd1, Object opnd2) {return new Menor((E)opnd1,(E)opnd2);}
	public E mayor(Object opnd1, Object opnd2) {return new Mayor((E)opnd1,(E)opnd2);}
	public E and(Object opnd1, Object opnd2) {return new And((E)opnd1,(E)opnd2);}
	public E or(Object opnd1, Object opnd2) {return new Or((E)opnd1,(E)opnd2);}
	public E igual(Object opnd1, Object opnd2) {return new Igual((E)opnd1,(E)opnd2);}
	public E distinto(Object opnd1, Object opnd2) {return new Distinto((E)opnd1,(E)opnd2);}
	public E array_init(Object opnd1, Object opnd2) {return new ArrayInit((E)opnd1,(E)opnd2);}
}
