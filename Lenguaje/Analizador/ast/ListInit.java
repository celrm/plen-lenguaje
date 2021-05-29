package ast;

public class ListInit extends E {
	private HomogValues lista;
	int n_elems = 0;
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
			n_elems = lista.vinculo();
	}
	@Override
	protected Typename chequea() throws Exception {
		if(lista == null) {
			tipo = new Typename(new Typename("*"), Type.ARR);
			tipo.shape.v = 0;
			return tipo;
		}
		tipo = new Typename(lista.chequea().pure(), Type.ARR);
		int tam = n_elems * lista.longit;
		tipo.shape.v = tam;
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
