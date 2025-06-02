package tp2.paradigmas.modelo;

public class FaseRobo implements EstadoTurno{

    @Override
    public void ejecutarFase(Turno turno, AccionTurno accion) {
        turno.getJugador().robarCarta();
        turno.cambiarFase(new FaseStandBy());
    }
}
