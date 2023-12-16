package TablasSimbolos;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashSet;

public class AnalizarFunciones {

   private static final Set<String> tiposValidos = new HashSet<>(Set.of(
           "int", "float", "char", "string", "bool", "array", "color", "object",
           "rect2", "vector2", "timespan", "resource", "aabb", "file", "error"
   ));

   public static void analizarCodigo(String codigo, JTable tablaFunciones, JTable tablaArreglos, JTable tablaVariables) {
      analizarFunciones(codigo, tablaFunciones);
      analizarArreglos(codigo, tablaArreglos);
      analizarVariables(codigo, tablaVariables);
   }

   private static void analizarVariables(String codigo, JTable tablaVariables) {
      String regexVariables = "\\b(" + String.join("|", tiposValidos) + ")\\b\\s+([a-zA-Z][a-zA-Z0-9_]*)\\s*=\\s*([^;]+)";
      Pattern patternVariables = Pattern.compile(regexVariables, Pattern.CASE_INSENSITIVE);
      Matcher matcherVariables = patternVariables.matcher(codigo);

      DefaultTableModel modeloVariables = (DefaultTableModel) tablaVariables.getModel();
      Set<String> nombresVariablesAgregados = new HashSet<>();

      while (matcherVariables.find()) {
         String identificadorVariable = matcherVariables.group(2);

         // Verificar si el nombre ya fue agregado a la tabla
         if (nombresVariablesAgregados.add(identificadorVariable)) {
            String tipoVariable = matcherVariables.group(1).toLowerCase();
            String valorVariable = matcherVariables.group(3).trim();

            modeloVariables.addRow(new Object[]{identificadorVariable, tipoVariable, valorVariable});
         }
      }

      if (!matcherVariables.hitEnd()) {
         // Manejar error: problemas con el patrón de búsqueda
         System.out.println("Error en el patron de busqueda de variables.");
      }
   }

   private static void analizarFunciones(String codigo, JTable tablaFunciones) {
      String regexFunciones = "func\\s+([a-zA-Z][a-zA-Z0-9_]*)\\s*\\(([^)]*)\\)\\s*\\{";
      Pattern patternFunciones = Pattern.compile(regexFunciones, Pattern.CASE_INSENSITIVE);
      Matcher matcherFunciones = patternFunciones.matcher(codigo);

      DefaultTableModel modeloFunciones = (DefaultTableModel) tablaFunciones.getModel();

      while (matcherFunciones.find()) {
         String nombreFuncion = matcherFunciones.group(1);
         String parametrosTexto = matcherFunciones.group(2).trim();

         if (parametrosTexto.isEmpty()) {
            modeloFunciones.addRow(new Object[]{nombreFuncion, 0, "Sin parametros"});
         } else {
            String[] parametros = parametrosTexto.split("\\s*,\\s*");
            int cantidadParametros = parametros.length;

            StringBuilder tiposParametros = new StringBuilder();
            for (int i = 0; i < cantidadParametros; i++) {
               String[] partes = parametros[i].split("\\s+");
               if (partes.length == 2) {
                  String tipoParametro = partes[0].toLowerCase();
                  if (tiposValidos.contains(tipoParametro)) {
                     tiposParametros.append(tipoParametro);
                  } else {
                     // Manejar error: tipo de parámetro no válido
                     tiposParametros.append("Error: Tipo de parametro no valido: ").append(tipoParametro);
                  }
               } else {
                  // Manejar error: formato de parámetro incorrecto
                  tiposParametros.append("Error en el formato del parametro: ").append(parametros[i]);
               }

               if (i < cantidadParametros - 1) {
                  tiposParametros.append(", ");
               }
            }

            modeloFunciones.addRow(new Object[]{nombreFuncion, cantidadParametros, tiposParametros.toString()});
         }
      }

      if (!matcherFunciones.hitEnd()) {
         // Manejar error: problemas con el patrón de búsqueda
         System.out.println("Error en el patron de busqueda de funciones.");
      }
   }

   private static void analizarArreglos(String codigo, JTable tablaArreglos) {
      String regexArreglos = "array\\s*\\[\\s*(\\w+)\\s*\\]\\s*([a-zA-Z][a-zA-Z0-9_]*)\\s*=\\s*\\[(.*?)\\]";
      Pattern patternArreglos = Pattern.compile(regexArreglos, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
      Matcher matcherArreglos = patternArreglos.matcher(codigo);

      DefaultTableModel modeloArreglos = (DefaultTableModel) tablaArreglos.getModel();
      Set<String> nombresArreglosAgregados = new HashSet<>();

      while (matcherArreglos.find()) {
         String nombreArreglo = matcherArreglos.group(2);

         // Verificar si el nombre ya fue agregado a la tabla
         if (nombresArreglosAgregados.add(nombreArreglo)) {
            String tipoElemento = matcherArreglos.group(1).toLowerCase();
            String elementosTexto = matcherArreglos.group(3).trim();

            String[] elementos = elementosTexto.isEmpty() ? new String[0] : elementosTexto.split("\\s*,\\s*");
            int cantidadElementos = elementos.length;

            // Ajuste: si el arreglo no tiene elementos, establecer elementosTexto como "vacío"
            if (elementos.length == 0) {
               elementosTexto = "vacío";
            }

            modeloArreglos.addRow(new Object[]{nombreArreglo, cantidadElementos, tipoElemento, elementosTexto});
         }
      }

      if (!matcherArreglos.hitEnd()) {
         // Manejar error: problemas con el patrón de búsqueda
         System.out.println("Error en el patron de busqueda de arreglos.");
      }
   }

}
