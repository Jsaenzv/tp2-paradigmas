package main.java.tp2.modelo;

public class ResultadoVictoria {
    private boolean hayGanador;
    private Jugador jugadorGanador; // 1 o 2 si hay ganador, -1 si no lo hay

    public ResultadoVictoria(boolean hayGanador, Jugador jugadorGanador) {
        this.hayGanador = hayGanador;
        this.jugadorGanador = jugadorGanador;
    }

    ResultadoVictoria() {
        this.hayGanador = false;
        this.jugadorGanador = null;
    }

    public boolean hayGanador() {
        return hayGanador;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public void setHayGanador(boolean hayGanador) {
        this.hayGanador = hayGanador;
    }
}

