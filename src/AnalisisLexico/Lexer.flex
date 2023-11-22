
package AnalisisLexico;

%%

%class Lexer
%public
%type Lexer
%line
%column
//%type Tokens
%{
    //Codigo de usuario
    public TablaErrores tablaError = new TablaErrores();
    public TablaToken tablaToken = new TablaToken();
%}


D = [0-9]+
LetraIni = [a-zA-ZñáéíóúüÁÉÍÓÚÜ]
Letra = [a-zA-Zñ_\-áéíóúüÁÉÍÓÚÜ]
FinalDeLinea = \r | \n |\r\n 
CualquierCaracterExceptoComillasDoblesOBarraInvertida   = ([^\\\"\n])   
CualquierCaracterExceptoApostrofeOBarrainvertida = ([^\\'])
NoSeparador = ([^\t\f\r\n\ \(\)\{\}\[\]\,\.\=\>\<\!\:\+\-\*\/\&\|\^\#\%\"\'a-zA-Z] |"\\")
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

/*Reservada = "int"|"float"|"const"|"char"|"String"|"bool"|"Array"|"Color"|"Rect2"|"Dictionary"|"extends"|"Vector2"|"File"|
            "return"|"new"|"AABB"|"TimeSpan"|"Resource"|"Object"|"Start"|"SceneTree"|"PhysicsShape"|"class"|"void"|"print"|
            "PhysicsBody"|"range"|"func"|"Error"|"for"|"while"|"if"|"elif"|"else"|"true"|"false"|"break"|"importAll"*/

Reservada = (i|I)(n|N)(t|T)|(f|F)(l|L)(o|O)(a|A)(t|T)|(c|C)(o|O)(n|N)(s|S)(t|T)|(c|C)(h|H)(a|A)(r|R)|(S|s)(t|T)(r|R)(i|I)(n|N)(g|G)|(b|B)(o|O)(o|O)(l|L)|(A|a)(r|R)(r|R)(a|A)(y|Y)|(C|c)(o|O)(l|L)(o|O)(r|R)|(R|r)(e|E)(c|C)(t|T)2|(D|d)(i|I)(c|C)(t|T)(i|I)(o|O)(n|N)(a|A)(r|R)(y|Y)|(e|E)(x|X)(t|T)(e|E)(n|N)(d|D)(s|S)|(V|v)(e|E)(c|C)(t|T)(o|O)(r|R)2|(F|f)(i|I)(l|L)(e|E)|(r|R)(e|E)(t|T)(u|U)(r|R)(n|N)|(n|N)(e|E)(w|W)|(A|a)(A|a)(B|b)(B|b)|(T|t)(i|I)(m|M)(e|E)(S|s)(p|P)(a|A)(n|N)|(R|r)(e|E)(s|S)(o|O)(u|U)(r|R)(c|C)(e|E)|(O|o)(b|B)(j|J)(e|E)(c|C)(t|T)|(S|s)(t|T)(a|A)(r|R)(t|T)|(S|s)(c|C)(e|E)(n|N)(e|E)(T|t)(r|R)(e|E)(e|E)|(P|p)(h|H)(y|Y)(s|S)(i|I)(c|C)(s|S)(S|s)(h|H)(a|A)(p|P)(e|E)|(c|C)(l|L)(a|A)(s|S)(s|S)|(v|V)(o|O)(i|I)(d|D)|(p|P)(r|R)(i|I)(n|N)(t|T)|(P|p)(h|H)(y|Y)(s|S)(i|I)(c|C)(s|S)(B|b)(o|O)(d|D)(y|Y)|(r|R)(a|A)(n|N)(g|G)(e|E)|(f|F)(u|U)(n|N)(c|C)|(E|e)(r|R)(r|R)(o|O)(r|R)|(f|F)(o|O)(r|R)|(w|W)(h|H)(i|I)(l|L)(e|E)|(i|I)(f|F)|(e|E)(l|L)(i|I)(f|F)|(e|E)(l|L)(s|S)(e|E)|(t|T)(r|R)(u|U)(e|E)|(f|F)(a|A)(l|L)(s|S)(e|E)|(b|B)(r|R)(e|E)(a|A)(k|K)|(i|I)(m|M)(p|P)(o|O)(r|R)(t|T)(A|a)(l|L)(l|L)|(i|I)(n|N)


//Patrones para los errores
IdentificadorError = ({D}{Identificador} | {NoSeparador}+{Identificador} | {Identificador}{NoSeparador}+ | {NoSeparador}+{Identificador}{NoSeparador}+ | {Identificador}{NoSeparador}+{Identificador})+

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
    
    "int"                       {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "float"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "const"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "char"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "String"                    {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "bool"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Array"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Color"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Rect2"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Dictionary"                {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "extends"                   {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Vector2"                   {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "File"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "return"                    {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "new"                       {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "AABB"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "TimeSpan"                  {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Resource"                  {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Object"                    {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Start"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "SceneTree"                 {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "PhysicsShape"              {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "class"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "void"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "print"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "PhysicsBody"               {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "func"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "Error"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "for"                       {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "while"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "if"                        {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "elif"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "else"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "true"                      {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "false"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "break"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "in"                        {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "range"                     {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
    "="                         {tablaToken.insertar(new Token(yytext(),"OpAsignacion",yyline+1,yycolumn+1));}
    "+="                        {tablaToken.insertar(new Token(yytext(),"OpAsignacion",yyline+1,yycolumn+1));}
    "-="                        {tablaToken.insertar(new Token(yytext(),"OpAsignacion",yyline+1,yycolumn+1));}
    "%="                        {tablaToken.insertar(new Token(yytext(),"OpAsignacion",yyline+1,yycolumn+1));}
    "*="                        {tablaToken.insertar(new Token(yytext(),"OpAsignacion",yyline+1,yycolumn+1));}
    "/="                        {tablaToken.insertar(new Token(yytext(),"OpAsignacion",yyline+1,yycolumn+1));}
    "!="                        {tablaToken.insertar(new Token(yytext(),"OpComparacion",yyline+1,yycolumn+1));}
    "=="                        {tablaToken.insertar(new Token(yytext(),"OpComparacion",yyline+1,yycolumn+1));}
    ">="                        {tablaToken.insertar(new Token(yytext(),"OpComparacion",yyline+1,yycolumn+1));}
    "<="                        {tablaToken.insertar(new Token(yytext(),"OpComparacion",yyline+1,yycolumn+1));}
    "<"                         {tablaToken.insertar(new Token(yytext(),"OpComparacion",yyline+1,yycolumn+1));}
    ">"                         {tablaToken.insertar(new Token(yytext(),"OpComparacion",yyline+1,yycolumn+1));}
    "+"                         {tablaToken.insertar(new Token(yytext(),"OpAritmetico",yyline+1,yycolumn+1));}
    "*"                         {tablaToken.insertar(new Token(yytext(),"OpAritmetico",yyline+1,yycolumn+1));}
    "/"                         {tablaToken.insertar(new Token(yytext(),"OpAritmetico",yyline+1,yycolumn+1));}
    "-"                         {tablaToken.insertar(new Token(yytext(),"OpAritmetico",yyline+1,yycolumn+1));}
    "%"                         {tablaToken.insertar(new Token(yytext(),"OpAritmetico",yyline+1,yycolumn+1));}
    "{"                         {tablaToken.insertar(new Token(yytext(),"SignoAgrupacion",yyline+1,yycolumn+1));}
    "}"                         {tablaToken.insertar(new Token(yytext(),"SignoAgrupacion",yyline+1,yycolumn+1));}
    "]"                         {tablaToken.insertar(new Token(yytext(),"SignoAgrupacion",yyline+1,yycolumn+1));}
    "["                         {tablaToken.insertar(new Token(yytext(),"SignoAgrupacion",yyline+1,yycolumn+1));}
    "("                         {tablaToken.insertar(new Token(yytext(),"SignoAgrupacion",yyline+1,yycolumn+1));}
    ")"                         {tablaToken.insertar(new Token(yytext(),"SignoAgrupacion",yyline+1,yycolumn+1));}
    ":"                         {tablaToken.insertar(new Token(yytext(),"SignoPuntuacion",yyline+1,yycolumn+1));}
    ","                         {tablaToken.insertar(new Token(yytext(),"SignoPuntuacion",yyline+1,yycolumn+1));}
    "&&"                        {tablaToken.insertar(new Token(yytext(),"OpLogico",yyline+1,yycolumn+1));}
    "||"                        {tablaToken.insertar(new Token(yytext(),"OpLogico",yyline+1,yycolumn+1));}
    "!"                         {tablaToken.insertar(new Token(yytext(),"OpLogico",yyline+1,yycolumn+1));}
    "\."                        {tablaToken.insertar(new Token(yytext(),"OpAccesoMiembros",yyline+1,yycolumn+1));}
    //"\""                        {tablaToken.insertar(new Token(yytext(),"ComillaDoble",yyline+1,yycolumn+1));}
    //"\'"                        {tablaToken.insertar(new Token(yytext(),"ComillaSimple",yyline+1,yycolumn+1));}
    {CadChar}                   {tablaToken.insertar(new Token(yytext(),"CadenaCaracter",yyline+1,yycolumn+1));}
    {CadenaCaracteres}          {tablaToken.insertar(new Token(yytext(),"CadenaCaracteres",yyline+1,yycolumn+1));} 
    {CadCaracteresError}        {tablaError.insertar(new ErrorToken(1,"Léxico","Se esperaba otra \". Verifica que la cadena de caracteres sea válida",yytext(),yyline+1,yycolumn+1));}
    {CadCharError}              {tablaError.insertar(new ErrorToken(2,"Léxico","Se esperaba otra \'. Verifica que la cadena de caracter sea válida",yytext(),yyline+1,yycolumn+1));}
    {CadCharError2}              {tablaError.insertar(new ErrorToken(3,"Léxico","Longitud excedida. Se esperaba un caracter",yytext(),yyline+1,yycolumn+1));}
    {OpLogicoFaltanteOR}           {tablaError.insertar(new ErrorToken(4,"Léxico","Se esperaba otro caracter |",yytext(),yyline+1,yycolumn+1));}
    {OpLogicoFaltanteAND}           {tablaError.insertar(new ErrorToken(4,"Léxico","Se esperaba otro caracter &",yytext(),yyline+1,yycolumn+1));}
    {NumFloatError}             {tablaError.insertar(new ErrorToken(5,"Léxico","Número decimal inválido. Verifica que coincida con el formato #.#, donde # representa dígitos",yytext(),yyline+1,yycolumn+1));}
    {NumEntError}               {tablaError.insertar(new ErrorToken(6,"Léxico","Número inválido. Verifica que coincida con el formato +# ó -#, donde # representa dígitos",yytext(),yyline+1,yycolumn+1));}
    {ReservadaError}            {tablaError.insertar(new ErrorToken(7,"Léxico","La cadena escrita no se reconoce como palabra reservada ó identificador. Verifica que contenga símbolos válidos e inténtalo de nuevo",yytext(),yyline+1,yycolumn+1));}
    {IdentificadorError}        {tablaError.insertar(new ErrorToken(8,"Léxico","Identificador inválido. Verifica que inicie con una letra y contenga símbolos válidos e inténtalo de nuevo",yytext(),yyline+1,yycolumn+1));}
    
    {Identificador}             {tablaToken.insertar(new Token(yytext(),"Identificador",yyline+1,yycolumn+1));}       
    {NumEntero}                 {tablaToken.insertar(new Token(yytext(),"NumEntero",yyline+1,yycolumn+1));} 
    {NumFloat}                  {tablaToken.insertar(new Token(yytext(),"NumFlotante",yyline+1,yycolumn+1));} 
      
    {ComentarioSimple}          {/**/}
    {ComentarioMultilinea}      {/**/}  
    {espacio}                   {/**/}
}

.                               {tablaError.insertar(new ErrorToken(9,"Léxico","Simbolo desconocido; revise que el simbolo coincida con el alfabeto",yytext(),yyline+1,yycolumn+1));}
