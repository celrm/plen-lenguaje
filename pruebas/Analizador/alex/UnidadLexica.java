package alex;

import java_cup.runtime.Symbol;

public class UnidadLexica extends Symbol {
   public UnidadLexica(int fila, int clase, String lexema) {
     super(clase,new TV(lexema,fila));
   }
   public int clase() {return sym;}
   public String lexema() {return ((TV)value).lexema;}
   public int fila() {return ((TV)value).fila;}
}
