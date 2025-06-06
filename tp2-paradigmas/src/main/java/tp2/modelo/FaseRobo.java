package main.java.tp2.modelo;

public class FaseRobo implements EstadoTurno{

    @Override
    public void ejecutarFase(Turno turno, AccionUsuario accion) {
        turno.getJugador().robarCarta();
        turno.cambiarFase(new FaseStandBy());
    }
}
