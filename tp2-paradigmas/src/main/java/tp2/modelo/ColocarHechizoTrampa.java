package main.java.tp2.modelo;

public class ColocarHechizoTrampa implements AccionFasePrincipal {
    private final HechizoTrampaEnCampo carta;

    public ColocarHechizoTrampa(HechizoTrampaEnCampo carta) {
        this.carta = carta;
    }

    @Override
    public void ejecutarAccion(Turno turno) {
        Jugador jugador = turno.getJugador();
        jugador.colocarCartaHechizoTrampa(carta);
    }
}

