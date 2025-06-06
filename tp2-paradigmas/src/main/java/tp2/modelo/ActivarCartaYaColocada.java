package main.java.tp2.modelo;

public class ActivarCartaYaColocada implements AccionUsuario {

    private final HechizoTrampaEnCampo cartaEnCampo;

    public ActivarCartaYaColocada(HechizoTrampaEnCampo cartaEnCampo) {
        this.cartaEnCampo = cartaEnCampo;
    }

    public void ejecutarAccion(Turno turno) {

        EstadoTurno fase = turno.getFaseActual();
        if (!(fase instanceof FasePrincipal)) {
            throw new RuntimeException("Solo se puede activar cartas en Fase Principal.");
        }

        Jugador jugador = turno.getJugador();

        if (!(cartaEnCampo.getPropietario() == jugador)) {
            throw new RuntimeException("Un jugador no puede activar cartas que no le pertenecen.");
        }

        if (!jugador.getMano().contains(cartaEnCampo)) {
            throw new RuntimeException("No tenés esa carta Hechizo en la mano para activarla.");
        }
        // Es CartaTrampa: solo se puede activar si ya estaba boca abajo en campo
        if (cartaEnCampo.estaBocaArriba()) {
            throw new RuntimeException("La carta ya está boca arriba o no está colocada.");
        }

        if (cartaEnCampo.getTurnoColocada().equals(turno.getNumeroTurno())) {
            throw new RuntimeException("No podés activar una Trampa en el mismo turno en que la colocaste.");
        }

        cartaEnCampo.ponerBocaArriba();
        cartaEnCampo.aplicarEfecto(jugador.getJuego());

        jugador.enviarAlCementerio(cartaEnCampo);
    }
}
