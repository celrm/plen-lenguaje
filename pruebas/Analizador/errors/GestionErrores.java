package errors;

import alex.UnidadLexica;
import alex.TV;
public class GestionErrores {
   public void errorLexico(int fila, String lexema) {
     System.out.println("ERROR fila "+fila+": Caracter inesperado:"+lexema); 
     //System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.out.print("ERROR fila "+unidadLexica.fila()+": Elemento inesperado:"+((TV)unidadLexica.value).lexema+"\n");
     //System.exit(1);
   }
}
