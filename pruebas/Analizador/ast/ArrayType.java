package ast;

public class ArrayType extends Typename {

	public ArrayType(Typename e) {
		super(e);
	}
	   public String toString() {
		   return "arr\\"+t1().toString();
		}
}
