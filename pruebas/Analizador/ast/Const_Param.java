package ast;

import alex.TV;

public class Const_Param extends Params {
	
	public Const_Param(Typename tipo, TV id, Params rest) {
		super(tipo,id,rest);
		is_const = true;
	}

}
