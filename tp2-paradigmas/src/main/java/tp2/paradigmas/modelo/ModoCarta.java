package tp2.paradigmas.modelo;

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
