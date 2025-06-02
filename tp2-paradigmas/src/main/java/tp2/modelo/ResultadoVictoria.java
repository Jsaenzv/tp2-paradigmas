package main.java.tp2.modelo;

public class ResultadoVictoria {
    private final boolean hayGanador;
    private final Jugador jugadorGanador; // 1 o 2 si hay ganador, -1 si no lo hay

    public ResultadoVictoria(boolean hayGanador, Jugador jugadorGanador) {
        this.hayGanador = hayGanador;
        this.jugadorGanador = jugadorGanador;
    }

    public boolean hayGanador() {
        return hayGanador;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }
}

