package alex;

import asint.ClaseLexica;
import errors.GestionErrores;

public class ALexOperations {
  private AnalizadorLexico alex;
  public ALexOperations(AnalizadorLexico alex) {
   this.alex = alex;
  }
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Id,alex.lexema()); 
  } 
  public UnidadLexica unidadEntero() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Entero,alex.lexema()); 
  } 
  public UnidadLexica unidadImport() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Import,alex.lexema()); 
  } 
  public UnidadLexica unidadFrom() {
     return new UnidadLexica(alex.fila(),ClaseLexica.From,alex.lexema()); 
  } 
  public UnidadLexica unidadType() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Type,alex.lexema()); 
  } 
  public UnidadLexica unidadConst() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Const,alex.lexema()); 
  } 
  public UnidadLexica unidadArr() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Arr,alex.lexema()); 
  } 
  public UnidadLexica unidadEnt() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Ent,alex.lexema()); 
  } 
  public UnidadLexica unidadBul() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Bul,alex.lexema()); 
  } 
  public UnidadLexica unidadCar() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Car,alex.lexema()); 
  } 
  public UnidadLexica unidadData() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Data,alex.lexema()); 
  } 
  public UnidadLexica unidadFunction() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Function,alex.lexema()); 
  }
  public UnidadLexica unidadReturn() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Return,alex.lexema()); 
  } 
  public UnidadLexica unidadMain() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Main,alex.lexema()); 
  } 
  public UnidadLexica unidadIf() {
     return new UnidadLexica(alex.fila(),ClaseLexica.If,alex.lexema()); 
  }   
  public UnidadLexica unidadElse() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Else,alex.lexema()); 
  } 
  public UnidadLexica unidadWhile() {
     return new UnidadLexica(alex.fila(),ClaseLexica.While,alex.lexema()); 
  } 
  public UnidadLexica unidadPunto() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Punto,alex.lexema()); 
  } 
  public UnidadLexica unidadLength() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Length,alex.lexema()); 
  } 
  public UnidadLexica unidadSi() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Si,alex.lexema()); 
  } 
  public UnidadLexica unidadNo() {
     return new UnidadLexica(alex.fila(),ClaseLexica.No,alex.lexema()); 
  } 
  public UnidadLexica unidadCaracter() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Caracter,alex.lexema()); 
  } 
  public UnidadLexica unidadAsignacion() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Asign,alex.lexema()); 
  } 
  public UnidadLexica unidadDistinto() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Distinto,alex.lexema()); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Igual,alex.lexema()); 
  } 
  public UnidadLexica unidadOr() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Or,alex.lexema()); 
  } 
  public UnidadLexica unidadAnd() {
     return new UnidadLexica(alex.fila(),ClaseLexica.And,alex.lexema()); 
  } 
  public UnidadLexica unidadMenor() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Menor,alex.lexema()); 
  } 
  public UnidadLexica unidadMeq() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Meq,alex.lexema()); 
  } 
  public UnidadLexica unidadMayor() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Mayor,alex.lexema()); 
  } 
  public UnidadLexica unidadMaq() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Maq,alex.lexema()); 
  } 
  public UnidadLexica unidadNot() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Not,alex.lexema()); 
  } 
  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Suma,alex.lexema()); 
  } 
  public UnidadLexica unidadGuion() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Guion,alex.lexema()); 
  } 
  public UnidadLexica unidadMultiplicacion() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Mul,alex.lexema()); 
  } 
  public UnidadLexica unidadDivision() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Div,alex.lexema()); 
  } 
  public UnidadLexica unidadModulo() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Mod,alex.lexema()); 
  } 
  public UnidadLexica unidadIndice() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Indice,alex.lexema()); 
  } 
  public UnidadLexica unidadAcceso() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Acceso,alex.lexema()); 
  } 
  public UnidadLexica unidadParentesisApertura() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PA,alex.lexema()); 
  } 
  public UnidadLexica unidadParentesisCierre() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PC,alex.lexema()); 
  } 
  public UnidadLexica unidadCorcheteApertura() {
     return new UnidadLexica(alex.fila(),ClaseLexica.CA,alex.lexema()); 
  } 
  public UnidadLexica unidadCorcheteCierre() {
     return new UnidadLexica(alex.fila(),ClaseLexica.CC,alex.lexema()); 
  } 
  public UnidadLexica unidadLlaveApertura() {
     return new UnidadLexica(alex.fila(),ClaseLexica.LA,alex.lexema()); 
  } 
  public UnidadLexica unidadLlaveCierre() {
     return new UnidadLexica(alex.fila(),ClaseLexica.LC,alex.lexema()); 
  }
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Coma,alex.lexema()); 
  }
  public UnidadLexica unidadDosPts() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DosPts,alex.lexema()); 
  }
  public UnidadLexica unidadBackslash() {
     return new UnidadLexica(alex.fila(),ClaseLexica.Backslash,alex.lexema()); 
  }
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),ClaseLexica.EOF,"<EOF>"); 
  }
}
