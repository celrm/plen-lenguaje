package exp;

import ast.Tipo;
import sem.SemRegistro;
import sem.Semantic;

public abstract class E {
   //public abstract TipoE tipo(); 
   public E opnd1() {throw new UnsupportedOperationException("opnd1");} 
   public E opnd2() {throw new UnsupportedOperationException("opnd2");}
   public abstract Semantic valor();
   public abstract Tipo tipo(); 
}