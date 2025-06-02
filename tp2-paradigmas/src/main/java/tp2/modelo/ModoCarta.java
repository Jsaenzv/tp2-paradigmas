package main.java.tp2.modelo;

public enum ModoCarta {
    ATAQUE,
    DEFENSA;

    public boolean esAtaque() {
        return this == ATAQUE;
    }

    public boolean esDefensa() {
        return this == DEFENSA;
    }
}
