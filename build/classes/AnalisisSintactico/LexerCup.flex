package AnalisisSintactico;
import java_cup.runtime.Symbol;

%%

%class LexerCup
%public
%type java_cup.runtime.Symbol
%line
%char
%cup
%full

%{
    //Codigo de usuario
    public TablaErrores tablaError = new TablaErrores();
    public TablaToken tablaToken = new TablaToken();
    
    private Symbol symbol (int type, Object value){
      return new Symbol(type,yyline,yycolumn,value);
    }
    private Symbol symbol (int type){
      return new Symbol(type,yyline,yycolumn);
    }
%}

D = [0-9]+
LetraIni = [a-zA-ZñÑáéíóúüÁÉÍÓÚÜ]
Letra = [a-zA-ZñÑ_áéíóúüÁÉÍÓÚÜ]
FinalDeLinea = \r | \n |\r\n 
CualquierCaracterExceptoComillasDoblesOBarraInvertida   = ([^\\\"\n])   
CualquierCaracterExceptoApostrofeOBarrainvertida = ([^\\'])
NoSeparador = ([^\t\f\r\n\ \(\)\{\}\[\]\,\.\=\>\<\!\:\+\-\*\/\&\|\^\#\%\"\'a-zA-ZñÑ_áéíóúüÁÉÍÓÚÜ0-9] |"\\")
EntradaCaracter = [^\r\n]
EntradaCaracterMultln = [^"-/"]+
espacio={FinalDeLinea} | [ \t\f]
ComentarioSimple = ("//"{EntradaCaracter}*{FinalDeLinea}*) | ("#"{EntradaCaracter}*{FinalDeLinea}*)
ComentarioMultilinea = "/-"{EntradaCaracterMultln}*"-/"

CadenaCaracteres = ([\"]({CualquierCaracterExceptoComillasDoblesOBarraInvertida})*[\"])
CadenaCaracteresNoCerrada = ([\"]([\\].|[^\\\"])*[^\"]?)
CadChar                 = ([\']({CualquierCaracterExceptoApostrofeOBarrainvertida}?)[\'])
CadCharNoCerrada         = ([\'][^\'\n]*[^\']?) 

Identificador = {LetraIni}({Letra}|{D})*
NumFloat = [-+]?{D}(\.{D})
NumEntero = [-+]?{D}+


Reservada = (i|I)(n|N)(t|T)|(f|F)(l|L)(o|O)(a|A)(t|T)|(c|C)(o|O)(n|N)(s|S)(t|T)|(c|C)(h|H)(a|A)(r|R)|(S|s)(t|T)(r|R)(i|I)(n|N)(g|G)|(b|B)(o|O)(o|O)(l|L)|(A|a)(r|R)(r|R)(a|A)(y|Y)|(C|c)(o|O)(l|L)(o|O)(r|R)|(R|r)(e|E)(c|C)(t|T)2|(D|d)(i|I)(c|C)(t|T)(i|I)(o|O)(n|N)(a|A)(r|R)(y|Y)|(e|E)(x|X)(t|T)(e|E)(n|N)(d|D)(s|S)|(V|v)(e|E)(c|C)(t|T)(o|O)(r|R)2|(F|f)(i|I)(l|L)(e|E)|(r|R)(e|E)(t|T)(u|U)(r|R)(n|N)|(n|N)(e|E)(w|W)|(A|a)(A|a)(B|b)(B|b)|(T|t)(i|I)(m|M)(e|E)(S|s)(p|P)(a|A)(n|N)|(R|r)(e|E)(s|S)(o|O)(u|U)(r|R)(c|C)(e|E)|(O|o)(b|B)(j|J)(e|E)(c|C)(t|T)|(S|s)(t|T)(a|A)(r|R)(t|T)|(S|s)(c|C)(e|E)(n|N)(e|E)(T|t)(r|R)(e|E)(e|E)|(P|p)(h|H)(y|Y)(s|S)(i|I)(c|C)(s|S)(S|s)(h|H)(a|A)(p|P)(e|E)|(c|C)(l|L)(a|A)(s|S)(s|S)|(v|V)(o|O)(i|I)(d|D)|(p|P)(r|R)(i|I)(n|N)(t|T)|(P|p)(h|H)(y|Y)(s|S)(i|I)(c|C)(s|S)(B|b)(o|O)(d|D)(y|Y)|(r|R)(a|A)(n|N)(g|G)(e|E)|(f|F)(u|U)(n|N)(c|C)|(E|e)(r|R)(r|R)(o|O)(r|R)|(f|F)(o|O)(r|R)|(w|W)(h|H)(i|I)(l|L)(e|E)|(i|I)(f|F)|(e|E)(l|L)(i|I)(f|F)|(e|E)(l|L)(s|S)(e|E)|(t|T)(r|R)(u|U)(e|E)|(f|F)(a|A)(l|L)(s|S)(e|E)|(b|B)(r|R)(e|E)(a|A)(k|K)|(i|I)(m|M)(p|P)(o|O)(r|R)(t|T)(A|a)(l|L)(l|L)|(i|I)(n|N)| (M|m)(o|O)(v|V)(e|E)(r|R)



//Patrones para los errores
IdentificadorError = ({D}{Identificador} | {NoSeparador}+{Identificador}{NoSeparador}* | {NoSeparador}*{Identificador}{NoSeparador}+ | {Identificador}{NoSeparador}+{Identificador})+

ReservadaError = ({NumFloat}|{NumFloatError})*{NoSeparador}+{Reservada} | {Reservada}{NoSeparador}+({NumFloat}|{NumFloatError})* | {Reservada}{IdentificadorError} | {IdentificadorError}{Reservada} | {Reservada}({NumFloat}|{NumFloatError})+

CadCharError = ({CadCharNoCerrada})
CadCharError2 = ([\']({CualquierCaracterExceptoApostrofeOBarrainvertida}{CualquierCaracterExceptoApostrofeOBarrainvertida}+)[\'])

CadCaracteresError = ({CadenaCaracteresNoCerrada})

NumFloatError = ([-+]*{D}[:jletter:]*(\.)+ | [-+]*(\.)+{D}[:jletter:]* | [-+]*(\.)+{D}[:jletter:]*(\.)+{D}[:jletter:]* | 
                [-+]*{D}[:jletter:]*(\.)+{D}[:jletter:]*(\.)+{D}[:jletter:]* | [+-][-+]+{D}[:jletter:]*(\.{D}[:jletter:]*) | 
                [-+]?{D}(\.{D}[:jletter:]+) | [-+]?{D}(\.({Identificador}|{IdentificadorError})+))+

NumEntError = [+-][+-]+{D} | [+-][+-]+{Identificador}

OpLogicoFaltanteOR = \|
OpLogicoFaltanteAND = \&

%%
<YYINITIAL>{
   (i|I)(n|N)(t|T) |
   (f|F)(l|L)(o|O)(a|A)(t|T) |
   (c|C)(h|H)(a|A)(r|R) |
   (S|s)(t|T)(r|R)(i|I)(n|N)(g|G) |
   (b|B)(o|O)(o|O)(l|L)                               {return new Symbol(sym.tipoDato,yychar,yyline,yytext());}
   
   (A|a)(r|R)(r|R)(a|A)(y|Y)                          {return new Symbol(sym.array,yychar,yyline,yytext());}
   (O|o)(b|B)(j|J)(e|E)(c|C)(t|T)                     {return new Symbol(sym.object,yychar,yyline,yytext());}
   (R|r)(e|E)(c|C)(t|T)2                              {return new Symbol(sym.rect2,yychar,yyline,yytext());}
   (V|v)(e|E)(c|C)(t|T)(o|O)(r|R)2                    {return new Symbol(sym.vector2,yychar,yyline,yytext());}
   (T|t)(i|I)(m|M)(e|E)(S|s)(p|P)(a|A)(n|N)           {return new Symbol(sym.timeSpan,yychar,yyline,yytext());}
   (R|r)(e|E)(s|S)(o|O)(u|U)(r|R)(c|C)(e|E)           {return new Symbol(sym.resource,yychar,yyline,yytext());}
   (A|a)(A|a)(B|b)(B|b)                               {return new Symbol(sym.aabb,yychar,yyline,yytext());}

   (i|I)(n|N)(p|P)(u|U)(t|T)(e|E)(v|V)(e|E)(n|N)(t|T)(k|K)(e|E)(y|Y) |
   (i|I)(n|N)(p|P)(u|U)(t|T)(e|E)(v|V)(e|E)(n|N)(t|T)(m|M)(o|O)(u|U)(s|S)(e|E)(b|B)(u|U)(t|T)(t|T)(o|O)(n|N) |
   (P|p)(h|H)(y|Y)(s|S)(i|I)(c|C)(s|S)(S|s)(h|H)(a|A)(p|P)(e|E) |
   (P|p)(h|H)(y|Y)(s|S)(i|I)(c|C)(s|S)(B|b)(o|O)(d|D)(y|Y) {return new Symbol(sym.funcionInterna,yychar,yyline,yytext());}

   (c|C)(o|O)(n|N)(s|S)(t|T)                          {return new Symbol(sym.constante,yychar,yyline,yytext());}  
   
   (i|I)(m|M)(p|P)(o|O)(r|R)(t|T)(A|a)(l|L)(l|L)      {return new Symbol(sym.importAll,yychar,yyline,yytext());}  
   
   (M|m)(o|O)(v|V)(e|E)(r|R)                          {return new Symbol(sym.mover,yychar,yyline,yytext());}
   (C|c)(o|O)(l|L)(o|O)(r|R)                          {return new Symbol(sym.color,yychar,yyline,yytext());}
   (e|E)(x|X)(t|T)(e|E)(n|N)(d|D)(s|S)                {return new Symbol(sym.extends,yychar,yyline,yytext());}
   (n|N)(e|E)(w|W)                                    {return new Symbol(sym.new,yychar,yyline,yytext());}
   (r|R)(e|E)(t|T)(u|U)(r|R)(n|N)                     {return new Symbol(sym.return,yychar,yyline,yytext());}
   (S|s)(t|T)(a|A)(r|R)(t|T)                          {return new Symbol(sym.start,yychar,yyline,yytext());}
   (c|C)(l|L)(a|A)(s|S)(s|S)                          {return new Symbol(sym.class,yychar,yyline,yytext());}
   (v|V)(o|O)(i|I)(d|D)                               {return new Symbol(sym.void,yychar,yyline,yytext());}
   (p|P)(r|R)(i|I)(n|N)(t|T)                          {return new Symbol(sym.print,yychar,yyline,yytext());}
   (f|F)(u|U)(n|N)(c|C)                               {return new Symbol(sym.func,yychar,yyline,yytext());}
   (f|F)(o|O)(r|R)                                    {return new Symbol(sym.for,yychar,yyline,yytext());}
   (w|W)(h|H)(i|I)(l|L)(e|E)                          {return new Symbol(sym.while,yychar,yyline,yytext());}
   (i|I)(f|F)                                         {return new Symbol(sym.if,yychar,yyline,yytext());}
   (e|E)(l|L)(i|I)(f|F)                               {return new Symbol(sym.elif,yychar,yyline,yytext());}
   (e|E)(l|L)(s|S)(e|E)                               {return new Symbol(sym.else,yychar,yyline,yytext());}
   (t|T)(r|R)(u|U)(e|E)                               {return new Symbol(sym.true,yychar,yyline,yytext());}
   (f|F)(a|A)(l|L)(s|S)(e|E)                          {return new Symbol(sym.false,yychar,yyline,yytext());}
   (b|B)(r|R)(e|E)(a|A)(k|K)                          {return new Symbol(sym.break,yychar,yyline,yytext());}
   (i|I)(n|N)                                         {return new Symbol(sym.in,yychar,yyline,yytext());}
   (r|R)(a|A)(n|N)(g|G)(e|E)                          {return new Symbol(sym.range,yychar,yyline,yytext());}
   
   "="                         {return new Symbol(sym.igual,yychar,yyline,yytext());}
   "+="                        {return new Symbol(sym.masIgual,yychar,yyline,yytext());}
   "-="                        {return new Symbol(sym.menosIgual,yychar,yyline,yytext());}
   "%="                        {return new Symbol(sym.modIgual,yychar,yyline,yytext());}
   "*="                        {return new Symbol(sym.porIgual,yychar,yyline,yytext());}
   "/="                        {return new Symbol(sym.divIgual,yychar,yyline,yytext());}
   "!="                        {return new Symbol(sym.notIgual,yychar,yyline,yytext());}
   "=="                        {return new Symbol(sym.igualIgual,yychar,yyline,yytext());}
   ">="                        {return new Symbol(sym.mayorIgual,yychar,yyline,yytext());}
   "<="                        {return new Symbol(sym.menorIgual,yychar,yyline,yytext());}
   "<"                         {return new Symbol(sym.menor,yychar,yyline,yytext());}
   ">"                         {return new Symbol(sym.mayor,yychar,yyline,yytext());}
   "+"                         {return new Symbol(sym.mas,yychar,yyline,yytext());}
   "*"                         {return new Symbol(sym.mul,yychar,yyline,yytext());}
   "/"                         {return new Symbol(sym.div,yychar,yyline,yytext());}
   "-"                         {return new Symbol(sym.resta,yychar,yyline,yytext());}
   "%"                         {return new Symbol(sym.mod,yychar,yyline,yytext());}
   "{"                         {return new Symbol(sym.llave_A,yychar,yyline,yytext());}
   "}"                         {return new Symbol(sym.llave_C,yychar,yyline,yytext());}
   "["                         {return new Symbol(sym.corch_A,yychar,yyline,yytext());}
   "]"                         {return new Symbol(sym.corch_C,yychar,yyline,yytext());}
   "("                         {return new Symbol(sym.paren_A,yychar,yyline,yytext());}
   ")"                         {return new Symbol(sym.paren_C,yychar,yyline,yytext());}
   ","                         {return new Symbol(sym.coma,yychar,yyline,yytext());}
   "&&"                        {return new Symbol(sym.and,yychar,yyline,yytext());}
   "||"                        {return new Symbol(sym.or,yychar,yyline,yytext());}
   "!"                         {return new Symbol(sym.not,yychar,yyline,yytext());}
   "\."                        {return new Symbol(sym.opAccMiembros,yychar,yyline,yytext());}
   
   {CadChar}                   {return new Symbol(sym.cadChar,yychar,yyline,yytext());}
   {CadenaCaracteres}          {return new Symbol(sym.cadCaracteres,yychar,yyline,yytext());} 
    
   {Identificador}             {return new Symbol(sym.identificador,yychar,yyline,yytext());}       
   {NumEntero}                 {return new Symbol(sym.numEntero,yychar,yyline,yytext());} 
   {NumFloat}                  {return new Symbol(sym.numFloat,yychar,yyline,yytext());} 
      
   {ComentarioSimple}          {/**/}
   {ComentarioMultilinea}      {/**/}  
   {espacio}                   {/**/}
}

.                               {return new Symbol(sym.error,yychar,yyline,yytext());}

