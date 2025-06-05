package tp2.modelo;

public class FaseFinal implements EstadoTurno{

    @Override
    public void ejecutarFase(Turno turno, AccionTurno accion) {
        turno.getJuego().resolverEfectos();
        turno.setJugador(turno.getJugador().getOponente()); // poner que el juego devuelva el oponente
    }
}
