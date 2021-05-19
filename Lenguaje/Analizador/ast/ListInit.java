package ast;

public class ListInit extends E {
	private HomogValues lista;
	public ListInit(HomogValues l, int fila) {
		super(Op.LISTA,fila);
		lista=l;
	}
	public String toString() {
		return "["+(lista==null?"":lista.toString())+"]";
	}
	@Override
	protected void vinculo() throws Exception {
		if(lista!=null)
			lista.vinculo();
	}
	@Override
	protected Typename chequea() throws Exception {
		if(lista == null)
			return new Typename(new Typename("*"), Type.ARR);
		return new Typename(lista.chequea().pure(), Type.ARR);
	}

}
