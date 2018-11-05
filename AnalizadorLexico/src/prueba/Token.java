package prueba;




public class Token {

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    private Tipos tipo;
    private String valor;

    public enum Tipos {
        NUMERO ("^\\d+$"),
        OPERADOR_BINARIO("[*|/|+|-]"),
        PALABRA_RESERVADA("while|for|if"),
        IDENTIFICADORES("(^[A-Za-z]+$)"),
        NUMERO_DECIMAL ("^[0-9]+[,][0-9]+?$");

        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }

}