
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Fri Apr 16 14:24:23 CEST 2021
//----------------------------------------------------

package asint;

import java_cup.runtime.*;
import alex.AnalizadorLexico;
import alex.UnidadLexica;
import errors.GestionErrores;
import ast.E;
import ast.ASExp;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Fri Apr 16 14:24:23 CEST 2021
  */
public class AnalizadorSintactico extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintactico() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\007\000\002\002\005\000\002\002\004\000\002\002" +
    "\003\000\002\003\005\000\002\003\003\000\002\004\003" +
    "\000\002\004\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\006\064\007\066\005\001\002\000\012\002" +
    "\ufffd\062\ufffd\063\ufffd\065\ufffd\001\002\000\012\002\ufffc" +
    "\062\ufffc\063\ufffc\065\ufffc\001\002\000\012\002\uffff\062" +
    "\uffff\063\014\065\uffff\001\002\000\006\064\007\066\005" +
    "\001\002\000\006\002\012\062\011\001\002\000\006\064" +
    "\007\066\005\001\002\000\004\002\000\001\002\000\012" +
    "\002\001\062\001\063\014\065\001\001\002\000\006\064" +
    "\007\066\005\001\002\000\012\002\ufffe\062\ufffe\063\ufffe" +
    "\065\ufffe\001\002\000\006\062\011\065\017\001\002\000" +
    "\012\002\ufffb\062\ufffb\063\ufffb\065\ufffb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\010\002\007\003\005\004\003\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\010" +
    "\002\015\003\005\004\003\001\001\000\002\001\001\000" +
    "\006\003\012\004\003\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\004\014\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
 
   errores = new GestionErrores();
   AnalizadorLexico alex = (AnalizadorLexico)getScanner();
   alex.fijaGestionErrores(errores);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }

 
   private GestionErrores errores;
   public void syntax_error(Symbol unidadLexica) {
     errores.errorSintactico((UnidadLexica)unidadLexica);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintactico$actions {


   private ASExp as = new ASExp();

  private final AnalizadorSintactico parser;

  /** Constructor */
  CUP$AnalizadorSintactico$actions(AnalizadorSintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action_part00000000(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintactico$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Exp ::= Exp MAS Term 
            {
              E RESULT =null;
		E aDeexp1 = (E)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).value;
		E aDeterm = (E)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 RESULT=as.suma(aDeexp1,aDeterm); 
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("Exp",0, RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Exp EOF 
            {
              Object RESULT =null;
		E start_val = (E)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintactico$parser.done_parsing();
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Exp ::= Term 
            {
              E RESULT =null;
		E aDeterm = (E)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 RESULT=aDeterm; 
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("Exp",0, RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Term ::= Term POR Fact 
            {
              E RESULT =null;
		E aDeterm1 = (E)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).value;
		E aDefact = (E)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 RESULT=as.mul(aDeterm1,aDefact); 
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Term ::= Fact 
            {
              E RESULT =null;
		E aDefact = (E)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 RESULT=aDefact; 
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Fact ::= NUM 
            {
              E RESULT =null;
		String lexDeNum = (String)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 RESULT = as.num(lexDeNum); 
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("Fact",2, RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Fact ::= PAP Exp PCIERRE 
            {
              E RESULT =null;
		E aDeexp = (E)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		 RESULT = aDeexp; 
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("Fact",2, RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalizadorSintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
              return CUP$AnalizadorSintactico$do_action_part00000000(
                               CUP$AnalizadorSintactico$act_num,
                               CUP$AnalizadorSintactico$parser,
                               CUP$AnalizadorSintactico$stack,
                               CUP$AnalizadorSintactico$top);
    }
}

