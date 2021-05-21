package asint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexico;
import ast.Program;

public class Main {
	public static String folder = null;
   public static void main(String[] args) throws Exception {
	 Program prog = abrirFichero(args[0]);
	 String code = prog.toString();
	 int index = 0;
	 for(String linea : code.split("\n")) {
		 System.out.println(index+ "\t"+linea);
		 index++;
	 }

	 prog.vinculo();
	 prog.chequea();
	 prog.codigo(args[0].substring(0, args[0].length()-4));
 }
   
   public static Program abrirFichero(String ruta) throws Exception {
	   String ruta2 = ruta; 
	   if(folder != null) {
		   ruta2 = folder + "/" + ruta + ".txt"; // imports
	   }
	   else {
		   File f = new File(ruta);
		   folder = f.getParent();
	   }
	     Reader input = new InputStreamReader(new FileInputStream(ruta2));
		 AnalizadorLexico alex = new AnalizadorLexico(input);
		 AnalizadorSintactico asint = new AnalizadorSintactico(alex);

		 return (Program) asint.parse().value;
   }
}
