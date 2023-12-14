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

   public static void analizarCodigo(String codigo, JTable tablaFunciones, JTable tablaArreglos) {
      analizarFunciones(codigo, tablaFunciones);
      analizarArreglos(codigo, tablaArreglos);
   }

   public static void analizarFunciones(String codigo, JTable tablaFunciones) {
      String regex = "func\\s+(\\w+)\\s*\\(([^)]*)\\)\\s*\\{";
      Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
      Matcher matcher = pattern.matcher(codigo);

      DefaultTableModel modeloTabla = (DefaultTableModel) tablaFunciones.getModel();

      while (matcher.find()) {
         String nombreFuncion = matcher.group(1);
         String parametrosTexto = matcher.group(2).trim();

         if (parametrosTexto.isEmpty()) {
            modeloTabla.addRow(new Object[]{nombreFuncion, 0, "Sin parametros", nombreFuncion.hashCode()});
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
                     tiposParametros.append("Error: Tipo de parametro no valido: ").append(tipoParametro);
                  }
               } else {
                  tiposParametros.append("Error en el formato del parametro: ").append(parametros[i]);
               }

               if (i < cantidadParametros - 1) {
                  tiposParametros.append(", ");
               }
            }

            modeloTabla.addRow(new Object[]{nombreFuncion, cantidadParametros, tiposParametros.toString(), Math.abs(nombreFuncion.hashCode())});
         }
      }

      if (!matcher.hitEnd()) {
         // Manejar error: problemas con el patrón de búsqueda
         System.out.println("Error en el patron de busqueda.");
      }
   }

   private static void analizarArreglos(String codigo, JTable tablaArreglos) {
      String regexArreglos = "array\\s*\\[\\s*(\\w+)\\s*\\]\\s*(\\w+)\\s*=\\s*\\[(.*?)\\]";
      Pattern patternArreglos = Pattern.compile(regexArreglos, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
      Matcher matcherArreglos = patternArreglos.matcher(codigo);

      DefaultTableModel modeloArreglos = (DefaultTableModel) tablaArreglos.getModel();

      while (matcherArreglos.find()) {
         String nombreArreglo = matcherArreglos.group(2);
         String tipoElemento = matcherArreglos.group(1).toLowerCase();
         String elementosTexto = matcherArreglos.group(3).trim();

         String[] elementos = elementosTexto.isEmpty() ? new String[0] : elementosTexto.split("\\s*,\\s*");
         int cantidadElementos = elementos.length;

         // Ajuste: si el arreglo no tiene elementos, establecer elementosTexto como "vacío"
         if (elementos.length == 0) {
            elementosTexto = "vacío";
         }

         modeloArreglos.addRow(new Object[]{nombreArreglo, cantidadElementos, tipoElemento, elementosTexto,Math.abs(nombreArreglo.hashCode())});
      }

      if (!matcherArreglos.hitEnd()) {
         // Manejar error: problemas con el patrón de búsqueda
         System.out.println("Error en el patron de busqueda de arreglos.");
      }
   }

}
