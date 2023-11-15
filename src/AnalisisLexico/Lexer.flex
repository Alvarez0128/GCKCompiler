
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


D=[0-9]+
FinalDeLinea = \r | \n |\r\n 
EntradaCaracter = [^\r\n]
EntradaCaracterMultln = [^ \r]
espacio={FinalDeLinea} | [ \t\f]
ComentarioSimple = ("//"{EntradaCaracter}*{FinalDeLinea}*) | ("#"{EntradaCaracter}*{FinalDeLinea}*)
ComentarioMultilinea = "/-"{EntradaCaracterMultln}*"-/"
CadenaCaracteres = \"{EntradaCaracter}*\"
Identificador = [:jletter:][:jletterdigit:]*
NumFloat = [-+]?{D}(\.{D})
NumEntero = [-+]?{D}+
Reservada = "int"|"float"|"const"|"char"|"String"|"bool"|"Array"|"Color"|"Rect2"|"Dictionary"|"extends"|"Vector2"|"File"|
            "return"|"new"|"AABB"|"TimeSpan"|"Resource"|"Object"|"Start"|"SceneTree"|"PhysicsShape"|"class"|"void"|"print"|
            "PhysicsBody"|"range"|"func"|"Error"|"for"|"while"|"if"|"elif"|"else"|"true"|"false"|"break"|"importAll"

//Patrones para los errores
IdentificadorError = ({D}{Identificador} | [^\t\n\r\f a-zA-Z]+{Identificador})+

ReservadaError = ({IdentificadorError}{Reservada} | [^\t\n\r\f a-zA-Z]+{Reservada} | {Reservada}{IdentificadorError})+

CadCaracteresError = \"{EntradaCaracter}*[^\"] | \" //| [^\"]{EntradaCaracter}*\"

NumFloatError = ([-+]*{D}[:jletter:]*(\.)+ | [-+]*(\.)+{D}[:jletter:]* | [-+]*(\.)+{D}[:jletter:]*(\.)+{D}[:jletter:]* | 
                [-+]*{D}[:jletter:]*(\.)+{D}[:jletter:]*(\.)+{D}[:jletter:]* | [+-][-+]+{D}[:jletter:]*(\.{D}[:jletter:]*) | 
                [-+]?{D}(\.{D}[:jletter:]+) | [-+]?{D}(\.({Identificador}|{IdentificadorError})+))+

NumEntError = [+-][+-]+{D} | [+-][+-]+{Identificador}


%%
<YYINITIAL>{
    {Reservada}                 {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
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
    {CadenaCaracteres}          {tablaToken.insertar(new Token(yytext(),"CadenaCaracteres",yyline+1,yycolumn+1));} 
    {CadCaracteresError}        {tablaError.insertar(new ErrorToken(1,"Léxico","Se esperaba otra \". Verifica que la cadena de caracteres sea válida",yytext(),yyline+1,yycolumn+1));}
    {NumFloatError}             {tablaError.insertar(new ErrorToken(2,"Léxico","Número decimal inválido. Verifica que coincida con el formato #.#",yytext(),yyline+1,yycolumn+1));}
    {NumEntError}               {tablaError.insertar(new ErrorToken(3,"Léxico","Número inválido. Verifica que coincida con el formato +# ó -#",yytext(),yyline+1,yycolumn+1));}
    {ReservadaError}            {tablaError.insertar(new ErrorToken(4,"Léxico","La cadena escrita no se reconoce como palabra reservada ó identificador. Verifica que la escribiste correctamente e inténtalo de nuevo",yytext(),yyline+1,yycolumn+1));}
    {IdentificadorError}        {tablaError.insertar(new ErrorToken(5,"Léxico","Identificador inválido. Verifica que inicie con una letra e inténtalo de nuevo",yytext(),yyline+1,yycolumn+1));}
    {Identificador}             {tablaToken.insertar(new Token(yytext(),"Identificador",yyline+1,yycolumn+1));}       
    {NumEntero}                 {tablaToken.insertar(new Token(yytext(),"NumEntero",yyline+1,yycolumn+1));} 
    {NumFloat}                  {tablaToken.insertar(new Token(yytext(),"NumFlotante",yyline+1,yycolumn+1));} 
    
    {ComentarioSimple}          {/**/}
    {ComentarioMultilinea}      {/**/}  
    {espacio}                   {/**/} 

}

.                               {tablaError.insertar(new ErrorToken(3,"Léxico","Simbolo desconocido; revise que el simbolo coincida con el alfabeto",yytext(),yyline+1,yycolumn+1));}
