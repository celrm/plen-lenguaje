package ast;

public class EPunt extends E {
   private E o1;
   public EPunt(E opnd1, Op oper, int fila) {
	   super(oper, fila);
	     this.o1 = opnd1;
   }
	@Override
	protected void vinculo() throws Exception {
		o1.vinculo();
	}
	@Override
	protected Typename chequea() throws Exception {
		Typename t = o1.chequea().pure();
		if(t.t != Type.PUNT)
			throw new Exception("Fila " + fila + ". No es puntero: "+ o1.toString());
		tipo= t.t_arr.pure();
		return tipo;
	}
	public String codigoD() {
		return o1.codigoD() +"\n"+
			"	i32.load\n";
	}
	@Override
	public String toString() {
		return this.oper().toString() + " " + o1.toString();
	}
	@Override
	protected String codigoE() {
		return codigoD() 
				+ "i32.load\n";
	}
}
