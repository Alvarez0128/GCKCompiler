
package AnalisisLexico;

import java.io.File;

public class GeneradorLexerJava {
    public static void main(String[] args) {
        //String ruta = "C:/Users/cesar/Documents/NetBeansProjects/Compilador/src/Léxico/Lexer.flex";
        String lexerFile = System.getProperty("user.dir") + "/src/AnalisisLexico/Lexer.flex";         
        generarLexer(lexerFile);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
