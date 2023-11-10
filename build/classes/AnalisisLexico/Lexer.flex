
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
EntradaComentMultln = [^\r]
espacio={FinalDeLinea} | [ \t\f]
ComentarioSimple = "//"{EntradaCaracter}*{FinalDeLinea}
ComentarioMultilinea = "/-"{EntradaComentMultln}*"-/"
CadenaCaracteres = \"{EntradaCaracter}*\"
Identificador = [:jletter:][:jletterdigit:]*
NumFloat = [-+]?{D}+(\.{D}+)
NumEntero = [-+]?{D}+

NumFloatError = [-+]?{D}(\.)+ | [-+]?(\.)+{D} | [-+]?(\.)+{D}\.(\.)+{D}

IdentificadorError = {D}{Identificador}



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
    "importAll"                 {tablaToken.insertar(new Token(yytext(),"RESERVADA",yyline+1,yycolumn+1));}
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
    {NumFloatError}             {tablaError.insertar(new ErrorToken(1,"Léxico","Numero decimal invalido",yytext(),yyline+1,yycolumn+1));}
    {IdentificadorError}        {tablaError.insertar(new ErrorToken(2,"Léxico","Identificador invalido",yytext(),yyline+1,yycolumn+1));}
    {Identificador}             {tablaToken.insertar(new Token(yytext(),"Identificador",yyline+1,yycolumn+1));}       
    {NumEntero}                 {tablaToken.insertar(new Token(yytext(),"NumEntero",yyline+1,yycolumn+1));} 
    {NumFloat}                  {tablaToken.insertar(new Token(yytext(),"NumFlotante",yyline+1,yycolumn+1));} 
    
    {ComentarioSimple}          {/**/}
    {ComentarioMultilinea}      {/**/}  
    {espacio}                   {/**/} 

}

.                               {tablaError.insertar(new ErrorToken(3,"Léxico","Simbolo desconocido",yytext(),yyline+1,yycolumn+1));}



