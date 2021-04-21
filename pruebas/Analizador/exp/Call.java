package exp;

import alex.TV;
import ast.HeterValues;
import ast.Tipo;
import sem.SemArray;
import sem.SemEnt;
import sem.Semantic;

public class Call extends E {
	TV id;
	HeterValues v;
	public Call(TV id, HeterValues v) {
		this.id = id;
		this.v = v;
	}
	public String toString() {
		return "call("+id.toString()+","+v.toString()+")";
	}
	public Semantic valor() {
		   SemEnt v1 = (SemEnt) (opnd1().valor());
		   Semantic v2 = (Semantic) (opnd2().valor());
		   return new SemArray(v1,v2);
	}
	public Tipo tipo() {
	   return opnd2().tipo();
	}

}
