package tp2.paradigmas.modelo;

import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private List<Tablero> tableros;
    private Turno turno;

    public void iniciar(Jugador jugador1, Jugador jugador2) {
        this.jugadores = List.of(jugador1, jugador2);

        Tablero tablero1 = new Tablero();
        Tablero tablero2 = new Tablero();
        this.tableros = List.of(tablero1, tablero2);

        jugador1.setTableroPropio(tablero1);
        jugador2.setTableroPropio(tablero2);

        this.turno = new Turno(jugador1, this);
    }

    public void avanzarTurno(AccionTurno accion) {
        turno.avanzar(accion);
    }

    public ResultadoVictoria verificarCondicionVictoria() {
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        if (jugador1.getPuntosVida() <= 0) {
            return new ResultadoVictoria(true, jugador2); // Gana jugador 2
        }

        if (jugador2.getPuntosVida() <= 0) {
            return new ResultadoVictoria(true, jugador1); // Gana jugador 1
        }

        if (jugador1.getMazo().isEmpty()) {
            return new ResultadoVictoria(true, jugador2);
        }

        if (jugador2.getMazo().isEmpty()) {
            return new ResultadoVictoria(true, jugador1);
        }

        return new ResultadoVictoria(false, new Jugador()); // No hay ganador todavía
    }

}
