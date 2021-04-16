
package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%class AnalizadorLexicoTiny
%unicode
%public

%{
private ALexOperations ops;
private GestionErroresTiny errores;
public String lexema() {return yytext();}
public int fila() {return yyline+1;}
public void fijaGestionErrores(GestionErroresTiny errores) {
this.errores = errores;
}
%}

%eofval{
return ops.unidadEof();
%eofval}

%init{
ops = new ALexOperations(this);
%init}

letraMayus = [A-Z]
letraMinus = [a-z]
letra  = ({letraMayus}|{letraMinus})
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
entero = {digitoPositivo}{digito}*
separador = [ \t\r\b\n]
comentario = €[^\.]*\.
import = import
from = from
type = type
const = const
arr = arr
ent = ent
bul = bul
car = car
data = data
function = function
return = return
main = main
if = if
else = else
while = while
punto = \.
length = length
si = si
no = no
caracter = '({letra}|{digito}|{separador})'

identificador = {letraMinus}({letraMinus}|{digito}|_)*

asignacion = \=
distinto = !\=
igual = \=\=
or = \|
and = &
menor = <
meq = <\=
mayor = >
maq = >\=
not = ¬
operadorSuma = \+
guion = \-
operadorMultiplicacion = \*
operadorDivision = /
operadorModulo = %
indice = !
acceso = \->
parentesisApertura = \(
parentesisCierre = \)
corcheteApertura = \[
corcheteCierre = \]
llaveApertura = \{
llaveCierre = \}
coma  = \,
dosPts = :


%%
{separador}               {}
{comentario}              {}
{identificador}           {return ops.unidadId();}
{entero}                  {return ops.unidadEntero();}
{import}                  {return ops.unidadImport();}
{from}                    {return ops.unidadFrom();}
{type}                    {return ops.unidadType();}
{const}                   {return ops.unidadConst();}
{arr}                     {return ops.unidadArr();}
{ent}                     {return ops.unidadEnt();}
{bul}                     {return ops.unidadBul();}
{car}                     {return ops.unidadCar();}
{data}                    {return ops.unidadData();}
{function}                {return ops.unidadFunction();}
{return}                  {return ops.unidadReturn();}
{main}                    {return ops.unidadMain();}
{if}                      {return ops.unidadIf();}
{else}                    {return ops.unidadElse();}
{while}                   {return ops.unidadWhile();}
{punto}                   {return ops.unidadPunto();}
{length}                  {return ops.unidadLength();}
{si}                      {return ops.unidadSi();}
{no}                      {return ops.unidadNo();}
{caracter}                {return ops.unidadCaracter();}
{asignacion}              {return ops.unidadAsignacion();}
{distinto}                {return ops.unidadDistinto();}
{igual}                   {return ops.unidadIgual();}
{or}                      {return ops.unidadOr();}
{and}                     {return ops.unidadAnd();}
{menor}                   {return ops.unidadMenor();}
{meq}                     {return ops.unidadMeq();}
{mayor}                   {return ops.unidadMayor();}
{maq}                     {return ops.unidadMaq();}
{not}                     {return ops.unidadNot();}
{operadorSuma}            {return ops.unidadSuma();}
{guion}                   {return ops.unidadGuion ();}
{operadorMultiplicacion}  {return ops.unidadMultiplicacion();}
{operadorDivision}        {return ops.unidadDivision();}
{operadorModulo}          {return ops.unidadModulo();}
{indice}                  {return ops.unidadIndice();}
{acceso}                  {return ops.unidadAcceso();}
{parentesisApertura}      {return ops.unidadParentesisApertura();}
{parentesisCierre}        {return ops.unidadParentesisCierre();}
{corcheteApertura}        {return ops.unidadCorcheteApertura();}
{corcheteCierre}          {return ops.unidadCorcheteCierre();}
{llaveApertura}           {return ops.unidadLlaveApertura();}
{llaveCierre}             {return ops.unidadLlaveCierre();}
{coma}                    {return ops.unidadComa();}
{dosPts}                  {return ops.unidadDosPts();}

[^]                       {errores.errorLexico(fila(),lexema());}
