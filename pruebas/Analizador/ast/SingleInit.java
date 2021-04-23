package ast;

import alex.TV;

public class SingleInit extends E {

	private TV opn;
	public SingleInit(TV opnd1) {
		opn = opnd1;
	}
	   public String toString() {
		   return opnd1().toString();
		}
	public TV opn() {
		return opn;
	}

}
