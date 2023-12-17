package TablasSimbolos;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashSet;

public class AnalizadorTablasSimbolos {

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
      String regexVariables = "\\b(" + String.join("|", tiposValidos) + ")\\b\\s+([a-zA-Z][a-zA-Z0-9ñÑ_áéíóúüÁÉÍÓÚÜ]*)(\\s*=\\s*(([a-zA-ZñÑáéíóúüÁÉÍÓÚÜ][a-zA-Z0-9ñÑ_áéíóúüÁÉÍÓÚÜ]*)|[-+]?[0-9]+(\\.[0-9]+)?|([\\\"]([^\\\\\"\\n])*(\\\\[^\\\"\\n])*)[\"]|([\\']([^\\\\'\\\\n])*(\\\\[^\\'\\\\n])*)[\']))?";
      Pattern patternVariables = Pattern.compile(regexVariables, Pattern.CASE_INSENSITIVE);

      DefaultTableModel modeloVariables = (DefaultTableModel) tablaVariables.getModel();
      Set<String> nombresVariablesAgregados = new HashSet<>();

      // Eliminar comentarios de una línea
      codigo = codigo.replaceAll("//[^\n]*", "");

      // Eliminar comentarios multilinea
      codigo = codigo.replaceAll("/\\*.*?\\*/", "");

      Matcher matcherVariables = patternVariables.matcher(codigo);

      while (matcherVariables.find()) {
         String identificadorVariable = matcherVariables.group(2);

         // Verificar si el nombre ya fue agregado a la tabla
         if (nombresVariablesAgregados.add(identificadorVariable)) {
            String tipoVariable = matcherVariables.group(1).toLowerCase();

            // Obtener el valor de la variable, o asignar un valor predeterminado si no se proporciona
            String valorVariable = "";
            if (matcherVariables.group(3) != null) {
               // Buscar la posición del igual y tomar la subcadena a partir de esa posición
               int posicionIgual = matcherVariables.group(3).indexOf('=');
               if (posicionIgual != -1) {
                  valorVariable = matcherVariables.group(3).substring(posicionIgual + 1).trim();
               }
            } else {
               // Asignar valor predeterminado según el tipo
               switch (tipoVariable) {
                  case "int":
                     valorVariable = "0";
                     break;
                  case "float":
                     valorVariable = "0.0";
                     break;
                  case "char":
                     valorVariable = "''";
                     break;
                  case "string":
                     valorVariable = "\"\"";
                     break;
                  // Agrega más casos según tus necesidades
                  default:
                     // Otros tipos, asignar un valor predeterminado
                     valorVariable = "undefined";
                     break;
               }
            }

            modeloVariables.addRow(new Object[]{identificadorVariable, tipoVariable, valorVariable});
         }
      }

      if (!matcherVariables.hitEnd()) {
         // Manejar error: problemas con el patrón de búsqueda
         System.out.println("Error en el patron de busqueda de variables.");
      }
   }

   private static void analizarFunciones(String codigo, JTable tablaFunciones) {
      String regexFuncionesDeclaradas = "func\\s+(\\w+)\\s*\\(([^)]*)\\)\\s*\\{";
      Pattern patternFuncionesDeclaradas = Pattern.compile(regexFuncionesDeclaradas, Pattern.CASE_INSENSITIVE);
      Matcher matcherFuncionesDeclaradas = patternFuncionesDeclaradas.matcher(codigo);

      DefaultTableModel modeloFunciones = (DefaultTableModel) tablaFunciones.getModel();

      while (matcherFuncionesDeclaradas.find()) {
         String nombreFuncion = matcherFuncionesDeclaradas.group(1);

         try {
            String parametrosTexto = matcherFuncionesDeclaradas.group(2).trim();
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
                        throw new IllegalArgumentException("Error: Tipo de parámetro no válido: " + tipoParametro);
                     }
                  } else {
                     throw new IllegalArgumentException("Error en el formato del parámetro: " + parametros[i]);
                  }

                  if (i < cantidadParametros - 1) {
                     tiposParametros.append(", ");
                  }
               }

               modeloFunciones.addRow(new Object[]{nombreFuncion, cantidadParametros, tiposParametros.toString()});
            }
         } catch (Exception e) {
            // Manejar el error (puedes imprimirlo o hacer lo que necesites)
            System.out.println("Error en la función " + nombreFuncion + ": " + e.getMessage());
         }
      }

      if (!matcherFuncionesDeclaradas.hitEnd()) {
         // Manejar error: problemas con el patrón de búsqueda
         System.out.println("Error en el patron de busqueda de funciones.");
      }
   }

   private static void analizarArreglos(String codigo, JTable tablaArreglos) {
      String regexArreglos = "array\\s*\\[\\s*(\\w+)\\s*\\]\\s*([a-zA-ZñÑáéíóúüÁÉÍÓÚÜ][a-zA-Z0-9ñÑ_áéíóúüÁÉÍÓÚÜ]*)\\s*=\\s*\\[([^\\]]*)\\]";
      Pattern patternArreglos = Pattern.compile(regexArreglos, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
      Matcher matcherArreglos = patternArreglos.matcher(codigo);

      DefaultTableModel modeloArreglos = (DefaultTableModel) tablaArreglos.getModel();
      Set<String> nombresArreglosAgregados = new HashSet<>();

      // Definir la expresión regular para un parámetro de arreglo
      String regexParametroArreglo = "([a-zA-ZñÑáéíóúüÁÉÍÓÚÜ][a-zA-Z0-9ñÑ_áéíóúüÁÉÍÓÚÜ]*)|[-+]?[0-9]+(\\.[0-9]+)?|([\\\"]([^\\\\\"\\n])*(\\\\[^\\\"\\n])*)[\"]|([\\']([^\\\\'\\\\n])*(\\\\[^\\'\\\\n])*)[\']";

      while (matcherArreglos.find()) {
         String nombreArreglo = matcherArreglos.group(2);

         // Verificar si el nombre ya fue agregado a la tabla
         if (nombresArreglosAgregados.add(nombreArreglo)) {
            try {
               String tipoElemento = matcherArreglos.group(1).toLowerCase();

               // Verificar que el tipo del arreglo esté en tiposValidos
               if (!tiposValidos.contains(tipoElemento)) {
                  throw new IllegalArgumentException("Error: Tipo de arreglo no válido - " + tipoElemento);
               }

               String elementosTexto = matcherArreglos.group(3).trim();

               String[] elementos = elementosTexto.isEmpty() ? new String[0] : elementosTexto.split("\\s*,\\s*");
               int cantidadElementos = elementos.length;

               // Ajuste: si el arreglo no tiene elementos, establecer elementosTexto como "vacío"
               if (elementos.length == 0) {
                  elementosTexto = "vacío";
               }

               // Validar que los elementos coincidan con la expresión regular ParametroArreglo
               Pattern patternParametro = Pattern.compile(regexParametroArreglo);
               for (String elemento : elementos) {
                  Matcher matcherParametro = patternParametro.matcher(elemento);
                  if (!matcherParametro.matches()) {
                     // Manejar error: elemento no válido
                     throw new IllegalArgumentException("Error: Elemento de arreglo no válido - " + elemento);
                  }
               }

               modeloArreglos.addRow(new Object[]{nombreArreglo, cantidadElementos, tipoElemento, elementosTexto});
            } catch (Exception e) {
               // Manejar el error (puedes imprimirlo o hacer lo que necesites)
               System.out.println("Error en el arreglo " + nombreArreglo + ": " + e.getMessage());
            }
         }
      }

      if (!matcherArreglos.hitEnd()) {
         // Manejar error: problemas con el patrón de búsqueda
         System.out.println("Error en el patron de busqueda de arreglos.");
      }
   }

}
