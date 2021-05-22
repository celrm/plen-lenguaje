package ast;

public class ListInit extends E {
	private HomogValues lista;
	int tam = 0;
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
			tam = lista.vinculo();
	}
	@Override
	protected Typename chequea() throws Exception {
		if(lista == null)
			return new Typename(new Typename("*"), Type.ARR);
		return new Typename(lista.chequea().pure(), Type.ARR);
	}
	protected String codigo(int delta) {
		String codeE = lista.codigo(delta);
		return codeE;
	}
	@Override
	protected String codigo() {// no funciona para algo que no sea una var
		// TODO Auto-generated method stub
		return null;
	}

}
