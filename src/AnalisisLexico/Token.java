
package AnalisisLexico;

/**
 *
 * @author cesar
 */
public class Token {
    String lexema;
    String grupoLexico;
    int linea;
    int columna;

    public Token(String lexema, String grupoLexico, int linea, int column) {
        this.lexema = lexema;
        this.grupoLexico = grupoLexico;
        this.linea = linea;
        this.columna = column;
    }
    
    public Object[] toArray(){
        return new Object[]{lexema,grupoLexico,linea,columna};
    }
    
}
