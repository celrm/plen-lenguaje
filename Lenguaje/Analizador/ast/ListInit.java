package ast;

public class ListInit extends E {
	private HomogValues lista;
	public ListInit(HomogValues l) {
		super(Op.LISTA);
		lista=l;
	}
	public String toString() {
		return "["+(lista==null?"":lista.toString())+"]";
	}
	@Override
	protected void vinculo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected String chequea() {
		// TODO Auto-generated method stub
		return null;
	}

}
