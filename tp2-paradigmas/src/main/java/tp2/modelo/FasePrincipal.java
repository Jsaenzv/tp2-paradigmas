package tp2.modelo;

public class FasePrincipal implements EstadoTurno {

    @Override
    public void ejecutarFase(Turno turno, AccionTurno accion) {
        accion.ejecutar(turno);
        turno.cambiarFase(new FaseCambios());
    }
}
