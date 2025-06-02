package tp2.paradigmas.modelo;

public class FaseStandBy implements EstadoTurno{

    @Override
    public void ejecutarFase(Turno turno, AccionTurno accion) {
    turno.getJuego().resolverEfectos();
    turno.cambiarFase(new FasePrincipal());

    }
}
