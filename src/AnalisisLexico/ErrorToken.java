
package AnalisisLexico;

/**
 *
 * @author cesar
 */
public class ErrorToken {
    int id;
    String tipo;
    String descripcion;
    int linea;
    int Column;
    String lexema;

    public ErrorToken(int id, String tipo, String descripcion,String lexema, int linea, int Column) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.Column = Column;
        this.lexema = lexema;
    }
    
    @Override
    public String toString() {
        return "Error "+tipo+" "+ id+": En la línea: " + linea + ", caracter: "+Column+" - descripción: " + descripcion + ", Cadena: " + lexema;
    }
    
    
}
