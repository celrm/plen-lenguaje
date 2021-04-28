package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexico;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
	 AnalizadorLexico alex = new AnalizadorLexico(input);
	 AnalizadorSintactico asint = new AnalizadorSintactico(alex);
	 
	 System.out.println(asint.parse().value);
 }
}
