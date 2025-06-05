package tp2.modelo;

public class Turno {
    private EstadoTurno faseActual;
    private Juego juego;
    private Jugador jugador;

    public Turno(Jugador jugador, Juego juego) {
        this.juego = juego;
        this.jugador = jugador;
        this.faseActual = new FaseRobo();
    }

    public void avanzar(AccionTurno accion) {
        faseActual.ejecutarFase(this, accion);
    }

    public void cambiarFase(EstadoTurno nuevaFase) {
        this.faseActual = nuevaFase;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador nuevoJugador) {
        this.jugador = nuevoJugador;
    }
    public Juego getJuego() {
        return juego;
    }
    public void setJuego(Juego nuevaJuego) {
        this.juego = nuevaJuego;
    }

}
