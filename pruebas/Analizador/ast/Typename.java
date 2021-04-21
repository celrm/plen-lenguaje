package ast;

import alex.TV;

public class Typename {
	private Typename t1;
	private TV tbasic;
	public Typename(TV e) {
		tbasic = e;
	}
	public Typename(Typename e) {
		t1 = e;
	}
	public Typename t1(){
		return t1;
	}
	public TV tb(){
		return tbasic;
	}
	public String toString() {
		if(tbasic!= null)
			return tbasic.toString();
		return t1.toString();
	}
}
