
package AnalisisLexico;

import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class TablaToken {
    ArrayList<Token> ts;
    public TablaToken(){
        ts = new ArrayList<>();
    }
    public void insertar(Token token){
        ts.add(token);
    }
    public ArrayList<Token> getTokens(){
        return ts;
    }
}
