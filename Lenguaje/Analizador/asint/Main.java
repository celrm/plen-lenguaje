package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexico;
import ast.Program;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
	 AnalizadorLexico alex = new AnalizadorLexico(input);
	 AnalizadorSintactico asint = new AnalizadorSintactico(alex);

	 Program prog = (Program) asint.parse().value;
	 
	 System.out.println(prog);

	 prog.vinculo();
	 prog.chequea();
 }
}
