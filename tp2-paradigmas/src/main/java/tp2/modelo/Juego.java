package main.java.tp2.modelo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Juego {
    private List<Jugador> jugadores;
    private Turno turno;
    private ResultadoVictoria resultadoVictoria;
    private List<EfectoCondicion> efectosAResolver;


    public void iniciar(Jugador jugador1, Jugador jugador2) {
        if (jugador1.getNombre().equals(jugador2.getNombre())) {
            throw new IllegalArgumentException("Ambos jugadores tienen el mismo nombre");
        }
        this.jugadores = List.of(jugador1, jugador2);

        Tablero tablero1 = new Tablero();
        Tablero tablero2 = new Tablero();

        jugador1.setTableroPropio(tablero1);
        jugador2.setTableroPropio(tablero2);
        jugador1.setJuego(this);
        jugador2.setJuego(this);

        this.turno = new Turno(jugador1, this);
        this.resultadoVictoria = new ResultadoVictoria();
    }

    public void avanzarTurno(AccionUsuario accion) {
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

        if (jugador1.getMazo().estaVacio()) {
            return new ResultadoVictoria(true, jugador2);
        }

        if (jugador2.getMazo().estaVacio()) {
            return new ResultadoVictoria(true, jugador1);
        }

        return new ResultadoVictoria(false, new Jugador()); // No hay ganador todavía
    }

    public void rendirJugador(Jugador ganador) {
        resultadoVictoria.setHayGanador(true);
        for (Jugador jugador : jugadores) {
            if (!jugador.equals(ganador)) {
                resultadoVictoria.setJugadorGanador(jugador);
            }

        }
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Integer getNumeroTurno() {
        return turno.getNumeroTurno();
    }

    public void resolverEfectos() {
        Iterator<EfectoCondicion> iterador = efectosAResolver.iterator();

        while (iterador.hasNext()) {
            EfectoCondicion efectoCondicion = iterador.next();

            if (efectoCondicion.seCumple()) {
                efectoCondicion.aplicar(this);
                iterador.remove();
            }
        }
    }

    public void agregarEfectoCondicion(EfectoCondicion efectoCondicion) {
        efectosAResolver.add(efectoCondicion);
    }

    public void eliminarEfectoCondicion(EfectoCondicion efectoCondicion) {
        efectosAResolver.remove(efectoCondicion);
    }

}
