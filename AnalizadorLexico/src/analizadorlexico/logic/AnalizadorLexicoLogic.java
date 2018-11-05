/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico.logic;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import prueba.Token;

/**
 *
 * @author user
 */
public class AnalizadorLexicoLogic {

    
    
    /**
     * public StringBuilder analizarPalabra (String palabra ){
        ArrayList<Token> tokens = lex(palabra);
        StringBuilder stb = new StringBuilder();
        if (tokens != null){
            tokens.forEach((token) -> {
            stb.append(token.getTipo()).append(": ").append(token.getValor());
            stb.append("\n");

        });
        return stb;
        }
        else {
            return stb.append("Error: Palabra no encontrada");
        }
    }*/
    
    private static ArrayList<Token> lex(String input) {
        final ArrayList<Token> tokens = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(input);

        while(st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean matched = false;

            for (Token.Tipos tokenTipo : Token.Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);
                if(matcher.find()) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tokens.add(tk);
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                return null;
            }
        }

        return tokens;
    }
    
    
    public String analizarPalabraCaracterACaracter (String palabra ){
        String result = "Error: Palabra no encontrada";
        if (isNumeroEntero(palabra)) {
            return result = "NÚMERO ENTERO: " + palabra;
        }else if (isNumeroReal(palabra)){
            return result = "NÚMERO REAL: " + palabra;
        }else if (isWhile(palabra)){
            return result = "PALABRA RESERVADA: " + palabra;
        }
        else if (isIf(palabra)){
            return result = "PALABRA RESERVADA: " + palabra;
        }
        else if (isFor(palabra)){
            return result = "PALABRA RESERVADA: " + palabra;
        }
        else if (isIdentificador(palabra)){
            return result = "IDENTIFICADOR: " + palabra;
        }
        
        return result;
    }
    
    private Boolean isNumeroEntero (String palabra){
        int i = 0;
        while(Character.isDigit(palabra.charAt(i))){
            i++;
            if(i==palabra.length()){
                return true;
            }
        }
        return false;
    }
    private Boolean isNumeroReal (String palabra){
        int i = 0;
        Boolean digit = false;
        if (palabra.contains(",") || palabra.contains(".")){
            
            while((Character.isDigit(palabra.charAt(i)) || !digit) && !Character.isLetter(palabra.charAt(i))){
            
                if (palabra.charAt(i) == ',' || palabra.charAt(i) == '.'){
                    digit = true;
                }
                i++;
                if(i==palabra.length()){
                    if (palabra.charAt(i-1) == ',' || palabra.charAt(i-1) == '.'){
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    private Boolean isIdentificador (String palabra){
        int i = 0;
        if (!Character.isDigit(palabra.charAt(i))){
            while(Character.isLetterOrDigit(palabra.charAt(i)) || palabra.charAt(i) == '$' || palabra.charAt(i) == '_'){
            i++;
                if(i==palabra.length()){
                    return true;
                }
            }
        }
        return false;
    }
    private Boolean isWhile (String palabra){
        //Comparar con while 
        int i = 0;
        char[] pWhile = {'w', 'h', 'i', 'l', 'e'};
        try {
            while( i < palabra.length() ){
            if(palabra.charAt(i) != pWhile[i]){
                return false;
            }
            i++;
            if(i==palabra.length()){
                return true;
            }
        }
        } catch (Exception e) {
            return false;
        }
        
    
    return false;
    }
    private Boolean isIf (String palabra){
        //Comparar con while 
        int i = 0;
        char[] pWhile = {'i', 'f'};
        try {
            while( i < palabra.length() ){
            if(palabra.charAt(i) != pWhile[i]){
            }
            i++;
            if(i==palabra.length()){
                return true;
            }
        }
        } catch (Exception e) {
            return false;
        }
        
    
    return false;
    }
    private Boolean isFor (String palabra){
        //Comparar con while 
        int i = 0;
        char[] pWhile = {'f', 'o', 'r'};
        try {
            while( i < palabra.length() ){
            if(palabra.charAt(i) != pWhile[i]){
                return false;
            }
            i++;
            if(i==palabra.length()){
                return true;
            }
        }
        } catch (Exception e) {
            return false;
        }
        
    
    return false;
    }

}
