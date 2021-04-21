package ast;

import alex.TV;

public class NoConst_Param extends Params {

	public NoConst_Param(Typename tipo, TV id, Params rest) {
		super(tipo,id,rest);
		is_const=false;
	}

}
