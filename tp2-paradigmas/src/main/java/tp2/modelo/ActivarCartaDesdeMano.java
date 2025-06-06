package main.java.tp2.modelo;

public class ActivarCartaDesdeMano implements AccionFasePrincipal {

    private final HechizoTrampaEnCampo cartaEnMano;

    public ActivarCartaDesdeMano(HechizoTrampaEnCampo cartaEnMano) {
        this.cartaEnMano = cartaEnMano;
    }

    @Override
    public void ejecutarAccion(Turno turno) {
        EstadoTurno fase = turno.getFaseActual();
        if (!(fase instanceof FasePrincipal)) {
            throw new RuntimeException("Solo se puede activar cartas desde la mano en Fase Principal.");
        }

        Jugador jugador = turno.getJugador();

        if (!jugador.getMano().contains(cartaEnMano)) {
            throw new RuntimeException("No tenés esa carta Hechizo/Trampa en la mano para activarla.");
        }

        jugador.getMano().remove(cartaEnMano);
        jugador.getTableroPropio().colocarHechizoTrampa(cartaEnMano);
        cartaEnMano.aplicarEfecto(jugador.getJuego());

    }
}
