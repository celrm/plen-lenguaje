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
		if(lista == null) {
			tipo = new Typename(new Typename("*"), Type.ARR);
			tipo.tam = 0;
			return tipo;
		}
		tipo = new Typename(lista.chequea().pure(), Type.ARR);
		tipo.tam = tam;
		return tipo;
	}
	protected String codigo(int delta, boolean hom) {
		String codeE = "";
		if(lista != null)
			codeE = lista.codigo(delta,hom);
		return codeE;
	}
	@Override
	protected String codigoE() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String codigoD() {
		// TODO Auto-generated method stub
		return null;
	}

}
