package ast;

import alex.TV;

public class Typename {
	private Typename t1;
	private TV tb;
	public Typename(TV e) {
		tb = e;
	}
	public Typename(Typename e) {
		t1 = e;
	}
	public Typename t1(){
		return t1;
	}
	public TV tb(){
		return tb;
	}
	public String toString() {
		return tb.toString();
	}
}
