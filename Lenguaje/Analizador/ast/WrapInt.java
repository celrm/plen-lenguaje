package ast;

public class WrapInt {
	public WrapInt(int i) {
		v=i;
	}
	public WrapInt() {}

	int v = 0;
	public String toString() {
		return Integer.toString(v);
	}
}
