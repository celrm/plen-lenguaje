package ast;

import alex.TV;

public class Typename {	
	private Typename t_arr;
	private TV t_id;

	public Typename(Typename t1) {this.t_arr=t1;}
	public Typename(TV id) {this.t_id=id;}
	public String toString() {
		if (t_arr != null) {
			return "arr\\" + t_arr.toString();
		}
		if(t_id != null) {
			return t_id.toString();
		}
		return "";
	}
	public String pure() {
		if(t_arr == null) {
			String from = t_id.toString();
			Typename to = Program.get_alias(from);
			while(to != null) {
				from = to.pure();
				to = Program.get_alias(from);
			}
			return from;
		}
		else {
			return "arr\\" + t_arr.pure();
		}
	}
}
