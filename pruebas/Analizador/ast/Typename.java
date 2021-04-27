package ast;

import alex.TV;

public class Typename {
	private Typename() {}
	public static final Typename BUL = new Typename();
	public static final Typename CAR = new Typename();
	public static final Typename ENT = new Typename();	
	
	private Typename t_arr;
	private TV t_id;

	public Typename(Typename t1) {this.t_arr=t1;}
	public Typename(TV id) {this.t_id=id;}
	public Typename t_arr() {
		return t_arr;
	}
	public TV t_id() {
		return t_id;
	}
}
