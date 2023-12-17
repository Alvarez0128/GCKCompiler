package AnalisisSintactico;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneradorLexerCupJava {

   public static void main(String[] args) throws Exception {
      String lexerCupFile = System.getProperty("user.dir") + "/src/AnalisisSintactico/LexerCup.flex";
      String[] rutaSintactico = {"-parser", "Sintax", System.getProperty("user.dir") + "/src/AnalisisSintactico/Sintax.cup"};
      generarLexerCup(lexerCupFile, rutaSintactico);
   }

   public static void generarLexerCup(String ruta, String[] rutaSintactico) throws IOException, Exception {
      File archivo;
      archivo = new File(ruta);
      jflex.Main.generate(archivo);
      
      java_cup.Main.main(rutaSintactico);
      
      Path rutaSym = Paths.get(System.getProperty("user.dir") + "/src/AnalisisSintactico/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(System.getProperty("user.dir") + "/sym.java"), 
                Paths.get(System.getProperty("user.dir") + "/src/AnalisisSintactico/sym.java")
        );
        Path rutaSin = Paths.get(System.getProperty("user.dir") + "/src/AnalisisSintactico/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(System.getProperty("user.dir") + "/Sintax.java"), 
                Paths.get(System.getProperty("user.dir") + "/src/AnalisisSintactico/Sintax.java")
        );
   }
}
