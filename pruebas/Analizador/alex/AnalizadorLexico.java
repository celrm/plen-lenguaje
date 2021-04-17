package alex;
import errors.GestionErrores;


public class AnalizadorLexico implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

  private ALexOperations ops;
  private GestionErrores errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErrores errores) {
   this.errores = errores;
  }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public AnalizadorLexico (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public AnalizadorLexico (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private AnalizadorLexico () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;

  ops = new ALexOperations(this);
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NOT_ACCEPT,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"3:8,1:3,3:2,1,3:18,1,31,3:3,41,33,27,42,43,39,37,48,38,25,40,5,4:9,49,3,34," +
"30,35,3:2,28:26,44,50,45,3,51,3,18,19,15,22,14,12,26,24,6,29:2,21,7,16,9,8," +
"29,10,17,11,20,29,23,29,13,29,46,32,47,3:46,36,3:8191,2,3:57171,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,107,
"0,1:2,2,1,3,4,1,5,6,1:2,7,8,1:2,9,1:12,10:3,1:5,10:4,1,10:11,11,12,13,14,15" +
",16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40" +
",41,42,43,44,45,46,47,48,49,50,51,52,53,54,10,55,56,57,58,59,60,61,62,63")[0];

	private int yy_nxt[][] = unpackFromString(64,52,
"1,2,3,4,5,4,6,55,97:2,99,101,102,97,73,74,56,57,75,76,97,103,104,105,97,7,9" +
"7,54,4,97,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,4,-1" +
":53,3:51,-1:4,5:2,-1:50,97:3,106,97:4,29,97:12,-1,97,-1:2,97,-1:21,97,-1:30" +
",32,-1:51,33,-1:51,34,-1:51,35,-1:56,36,-1:20,97:21,-1,97,-1:2,97,-1:21,97," +
"-1:27,41,-1:28,53:21,-1,53,-1,53:2,-1:26,97:14,77,97:6,-1,97,-1:2,97,-1:21," +
"97,-1:4,97:5,30,97:15,-1,97,-1:2,97,-1:21,97,-1:4,97:2,31,97:18,-1,97,-1:2," +
"97,-1:21,97,-1:4,97:7,37,97:13,-1,97,-1:2,97,-1:21,97,-1:4,97:6,38,97:14,-1" +
",97,-1:2,97,-1:21,97,-1:4,97:6,39,97:14,-1,97,-1:2,97,-1:21,97,-1:4,97:17,4" +
"0,97:3,-1,97,-1:2,97,-1:21,97,-1:4,97:12,42,97:8,-1,97,-1:2,97,-1:21,97,-1:" +
"4,97:10,43,97:10,-1,97,-1:2,97,-1:21,97,-1:4,97:3,44,97:17,-1,97,-1:2,97,-1" +
":21,97,-1:4,97:10,45,97:10,-1,97,-1:2,97,-1:21,97,-1:4,97:14,46,97:6,-1,97," +
"-1:2,97,-1:21,97,-1:4,97:7,47,97:13,-1,97,-1:2,97,-1:21,97,-1:4,97:10,48,97" +
":10,-1,97,-1:2,97,-1:21,97,-1:4,97:7,49,97:13,-1,97,-1:2,97,-1:21,97,-1:4,9" +
"7:12,50,97:8,-1,97,-1:2,97,-1:21,97,-1:4,97:20,51,-1,97,-1:2,97,-1:21,97,-1" +
":4,97:12,52,97:8,-1,97,-1:2,97,-1:21,97,-1:4,97:12,58,97:4,82,97:3,-1,97,-1" +
":2,97,-1:21,97,-1:4,97:5,98,97:8,59,97:6,-1,97,-1:2,97,-1:21,97,-1:4,97:6,6" +
"0,97:14,-1,97,-1:2,97,-1:21,97,-1:4,97:16,61,97:4,-1,97,-1:2,97,-1:21,97,-1" +
":4,97:2,62,97:18,-1,97,-1:2,97,-1:21,97,-1:4,97:7,86,97:13,-1,97,-1:2,97,-1" +
":21,97,-1:4,97:4,63,97:16,-1,97,-1:2,97,-1:21,97,-1:4,97:5,64,97:15,-1,97,-" +
"1:2,97,-1:21,97,-1:4,97:12,87,97:8,-1,97,-1:2,97,-1:21,97,-1:4,97:13,65,97:" +
"7,-1,97,-1:2,97,-1:21,97,-1:4,97:7,66,97:13,-1,97,-1:2,97,-1:21,97,-1:4,97:" +
"2,90,97:18,-1,97,-1:2,97,-1:21,97,-1:4,97:5,91,97:15,-1,97,-1:2,97,-1:21,97" +
",-1:4,97:16,92,97:4,-1,97,-1:2,97,-1:21,97,-1:4,97:11,93,97:9,-1,97,-1:2,97" +
",-1:21,97,-1:4,97:13,67,97:7,-1,97,-1:2,97,-1:21,97,-1:4,97:21,-1,94,-1:2,9" +
"7,-1:21,97,-1:4,97:17,68,97:3,-1,97,-1:2,97,-1:21,97,-1:4,97:6,69,97:14,-1," +
"97,-1:2,97,-1:21,97,-1:4,97:6,70,97:14,-1,97,-1:2,97,-1:21,97,-1:4,97:7,95," +
"97:13,-1,97,-1:2,97,-1:21,97,-1:4,97:7,71,97:13,-1,97,-1:2,97,-1:21,97,-1:4" +
",97:2,96,97:18,-1,97,-1:2,97,-1:21,97,-1:4,97:5,72,97:15,-1,97,-1:2,97,-1:2" +
"1,97,-1:4,97:12,88,97:8,-1,97,-1:2,97,-1:21,97,-1:4,97:10,78,97:10,-1,97,-1" +
":2,97,-1:21,97,-1:4,97:12,89,97:8,-1,97,-1:2,97,-1:21,97,-1:4,97:9,79,97:11" +
",-1,97,-1:2,97,-1:21,97,-1:4,97:6,80,97:9,81,97:4,-1,97,-1:2,97,-1:21,97,-1" +
":4,97:10,100,97:10,-1,97,-1:2,97,-1:21,97,-1:4,97:14,83,97:6,-1,97,-1:2,97," +
"-1:21,97,-1:4,97:20,84,-1,97,-1:2,97,-1:21,97,-1:4,97:4,85,97:16,-1,97,-1:2" +
",97,-1:21,97");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return ops.unidadEof();
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{}
					case -3:
						break;
					case 3:
						{}
					case -4:
						break;
					case 4:
						{errores.errorLexico(fila(),lexema());}
					case -5:
						break;
					case 5:
						{return ops.unidadEntero();}
					case -6:
						break;
					case 6:
						{return ops.unidadId();}
					case -7:
						break;
					case 7:
						{return ops.unidadPunto();}
					case -8:
						break;
					case 8:
						{return ops.unidadAsignacion();}
					case -9:
						break;
					case 9:
						{return ops.unidadIndice();}
					case -10:
						break;
					case 10:
						{return ops.unidadOr();}
					case -11:
						break;
					case 11:
						{return ops.unidadAnd();}
					case -12:
						break;
					case 12:
						{return ops.unidadMenor();}
					case -13:
						break;
					case 13:
						{return ops.unidadMayor();}
					case -14:
						break;
					case 14:
						{return ops.unidadNot();}
					case -15:
						break;
					case 15:
						{return ops.unidadSuma();}
					case -16:
						break;
					case 16:
						{return ops.unidadGuion ();}
					case -17:
						break;
					case 17:
						{return ops.unidadMultiplicacion();}
					case -18:
						break;
					case 18:
						{return ops.unidadDivision();}
					case -19:
						break;
					case 19:
						{return ops.unidadModulo();}
					case -20:
						break;
					case 20:
						{return ops.unidadParentesisApertura();}
					case -21:
						break;
					case 21:
						{return ops.unidadParentesisCierre();}
					case -22:
						break;
					case 22:
						{return ops.unidadCorcheteApertura();}
					case -23:
						break;
					case 23:
						{return ops.unidadCorcheteCierre();}
					case -24:
						break;
					case 24:
						{return ops.unidadLlaveApertura();}
					case -25:
						break;
					case 25:
						{return ops.unidadLlaveCierre();}
					case -26:
						break;
					case 26:
						{return ops.unidadComa();}
					case -27:
						break;
					case 27:
						{return ops.unidadDosPts();}
					case -28:
						break;
					case 28:
						{return ops.unidadBackslash();}
					case -29:
						break;
					case 29:
						{return ops.unidadIf();}
					case -30:
						break;
					case 30:
						{return ops.unidadNo();}
					case -31:
						break;
					case 31:
						{return ops.unidadSi();}
					case -32:
						break;
					case 32:
						{return ops.unidadIgual();}
					case -33:
						break;
					case 33:
						{return ops.unidadDistinto();}
					case -34:
						break;
					case 34:
						{return ops.unidadMeq();}
					case -35:
						break;
					case 35:
						{return ops.unidadMaq();}
					case -36:
						break;
					case 36:
						{return ops.unidadAcceso();}
					case -37:
						break;
					case 37:
						{return ops.unidadEnt();}
					case -38:
						break;
					case 38:
						{return ops.unidadCar();}
					case -39:
						break;
					case 39:
						{return ops.unidadArr();}
					case -40:
						break;
					case 40:
						{return ops.unidadBul();}
					case -41:
						break;
					case 41:
						{return ops.unidadCaracter();}
					case -42:
						break;
					case 42:
						{return ops.unidadMain();}
					case -43:
						break;
					case 43:
						{return ops.unidadType();}
					case -44:
						break;
					case 44:
						{return ops.unidadFrom();}
					case -45:
						break;
					case 45:
						{return ops.unidadElse();}
					case -46:
						break;
					case 46:
						{return ops.unidadData();}
					case -47:
						break;
					case 47:
						{return ops.unidadConst();}
					case -48:
						break;
					case 48:
						{return ops.unidadWhile();}
					case -49:
						break;
					case 49:
						{return ops.unidadImport();}
					case -50:
						break;
					case 50:
						{return ops.unidadReturn();}
					case -51:
						break;
					case 51:
						{return ops.unidadLength();}
					case -52:
						break;
					case 52:
						{return ops.unidadFunction();}
					case -53:
						break;
					case 54:
						{errores.errorLexico(fila(),lexema());}
					case -54:
						break;
					case 55:
						{return ops.unidadId();}
					case -55:
						break;
					case 56:
						{return ops.unidadId();}
					case -56:
						break;
					case 57:
						{return ops.unidadId();}
					case -57:
						break;
					case 58:
						{return ops.unidadId();}
					case -58:
						break;
					case 59:
						{return ops.unidadId();}
					case -59:
						break;
					case 60:
						{return ops.unidadId();}
					case -60:
						break;
					case 61:
						{return ops.unidadId();}
					case -61:
						break;
					case 62:
						{return ops.unidadId();}
					case -62:
						break;
					case 63:
						{return ops.unidadId();}
					case -63:
						break;
					case 64:
						{return ops.unidadId();}
					case -64:
						break;
					case 65:
						{return ops.unidadId();}
					case -65:
						break;
					case 66:
						{return ops.unidadId();}
					case -66:
						break;
					case 67:
						{return ops.unidadId();}
					case -67:
						break;
					case 68:
						{return ops.unidadId();}
					case -68:
						break;
					case 69:
						{return ops.unidadId();}
					case -69:
						break;
					case 70:
						{return ops.unidadId();}
					case -70:
						break;
					case 71:
						{return ops.unidadId();}
					case -71:
						break;
					case 72:
						{return ops.unidadId();}
					case -72:
						break;
					case 73:
						{return ops.unidadId();}
					case -73:
						break;
					case 74:
						{return ops.unidadId();}
					case -74:
						break;
					case 75:
						{return ops.unidadId();}
					case -75:
						break;
					case 76:
						{return ops.unidadId();}
					case -76:
						break;
					case 77:
						{return ops.unidadId();}
					case -77:
						break;
					case 78:
						{return ops.unidadId();}
					case -78:
						break;
					case 79:
						{return ops.unidadId();}
					case -79:
						break;
					case 80:
						{return ops.unidadId();}
					case -80:
						break;
					case 81:
						{return ops.unidadId();}
					case -81:
						break;
					case 82:
						{return ops.unidadId();}
					case -82:
						break;
					case 83:
						{return ops.unidadId();}
					case -83:
						break;
					case 84:
						{return ops.unidadId();}
					case -84:
						break;
					case 85:
						{return ops.unidadId();}
					case -85:
						break;
					case 86:
						{return ops.unidadId();}
					case -86:
						break;
					case 87:
						{return ops.unidadId();}
					case -87:
						break;
					case 88:
						{return ops.unidadId();}
					case -88:
						break;
					case 89:
						{return ops.unidadId();}
					case -89:
						break;
					case 90:
						{return ops.unidadId();}
					case -90:
						break;
					case 91:
						{return ops.unidadId();}
					case -91:
						break;
					case 92:
						{return ops.unidadId();}
					case -92:
						break;
					case 93:
						{return ops.unidadId();}
					case -93:
						break;
					case 94:
						{return ops.unidadId();}
					case -94:
						break;
					case 95:
						{return ops.unidadId();}
					case -95:
						break;
					case 96:
						{return ops.unidadId();}
					case -96:
						break;
					case 97:
						{return ops.unidadId();}
					case -97:
						break;
					case 98:
						{return ops.unidadId();}
					case -98:
						break;
					case 99:
						{return ops.unidadId();}
					case -99:
						break;
					case 100:
						{return ops.unidadId();}
					case -100:
						break;
					case 101:
						{return ops.unidadId();}
					case -101:
						break;
					case 102:
						{return ops.unidadId();}
					case -102:
						break;
					case 103:
						{return ops.unidadId();}
					case -103:
						break;
					case 104:
						{return ops.unidadId();}
					case -104:
						break;
					case 105:
						{return ops.unidadId();}
					case -105:
						break;
					case 106:
						{return ops.unidadId();}
					case -106:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
