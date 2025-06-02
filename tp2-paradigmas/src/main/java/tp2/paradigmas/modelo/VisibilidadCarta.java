package tp2.paradigmas.modelo;

public enum VisibilidadCarta {
    BOCA_ARRIBA,
    BOCA_ABAJO;

    public boolean estaBocaArriba() {
        return this == BOCA_ARRIBA;
    }

    public boolean estaBocaAbajo() {
        return this == BOCA_ABAJO;
    }
}
