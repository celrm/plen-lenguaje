package exp;

import java.util.List;

import ast.HomogValues;

public class ListInit extends E {
	private List<E> list;
	public ListInit(HomogValues l) {
		list=l.list();
	}
	public List<E> list() {
		return list;
	}

}
