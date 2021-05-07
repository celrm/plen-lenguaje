package asint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexico;
import ast.Program;

public class Main {
   public static void main(String[] args) throws Exception {
	 Program prog = abrirFichero(args[0]);
	 System.out.println(prog);

	 prog.vinculo();
	 prog.chequea();
 }
   
   protected static Program abrirFichero(String ruta) throws Exception {
	     Reader input = new InputStreamReader(new FileInputStream(ruta));
		 AnalizadorLexico alex = new AnalizadorLexico(input);
		 AnalizadorSintactico asint = new AnalizadorSintactico(alex);

		 return (Program) asint.parse().value;
   }
}
