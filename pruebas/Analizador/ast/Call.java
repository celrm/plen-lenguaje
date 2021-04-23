package ast;

import alex.TV;

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
//	public Tipo tipo() {
//	   return opnd2().tipo();
//	}

}
