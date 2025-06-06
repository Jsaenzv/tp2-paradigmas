package main.java.tp2.modelo;

public class CartaMonstruo extends Carta {
    private final int nivel;
    private final int atk;
    private final int def;
    private final Elemento elemento;
    private final Atributo atributo;

    public CartaMonstruo(String nombre, int nivel, int atk, int def, Elemento elemento, Atributo atributo) {
        super(nombre);
        this.nivel = nivel;
        this.atk = atk;
        this.def = def;
        this.elemento = elemento;
        this.atributo = atributo;
    }


    public Integer cantSacrificiosRequeridos() {
       if (nivel <= 4) {
           return 0;
       }
       else if (nivel <= 6) {
           return 1;
       }
       else {
           return 2;
       }
    }

    public Elemento getElemento() {
        return elemento;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }
    public int getNivel() {
        return nivel;
    }

    public Atributo getAtributo() {
        return atributo;
    }
}
