package ast;

import alex.TV;

public class Typename {	
	private Typename t_arr;
	private TV t_id;
	private String string;

	public Typename(String string) {this.string=string;}
	
	public Typename(TV id) {this.t_id=id;}
	public Typename(Typename e) {t_arr = e;	}

	public String toString() {
		if (t_arr != null) {
			return "arr\\" + t_arr.toString();
		}
		if(t_id != null) {
			return t_id.toString();
		}
		return string;
	}
	public String pure() {
		if(t_id != null) {
			String from = t_id.toString();
			Typename to = Program.get_alias(from);
			while(to != null) {
				from = to.pure();
				to = Program.get_alias(from);
			}
			return from;
		}
		else if (t_arr != null) {
			return "arr\\" + t_arr.pure();
		}
		return string;
	}
}
