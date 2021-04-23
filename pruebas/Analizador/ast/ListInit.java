package ast;

import java.util.ArrayList;
import java.util.List;

public class ListInit extends E {
	private List<E> list;
	public ListInit(HomogValues l) {
		if(l == null) 
			list = new ArrayList<E>();
		else
			list=l.list();
	}
	public List<E> list() {
		return list;
	}

}
